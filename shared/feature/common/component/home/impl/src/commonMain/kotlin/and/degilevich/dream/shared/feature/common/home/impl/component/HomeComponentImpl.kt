package and.degilevich.dream.shared.feature.common.home.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerManager
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarManager
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponent
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeDrawer
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeTopbar
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomeIntent
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.impl.view.HomeScreen
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.ChildDrawer
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.DrawerNavigation
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.childDrawer
import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponent
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.router.pages.setItems
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

internal class HomeComponentImpl(
    componentContext: ComponentContext
) : BaseComponent(
    componentContext = componentContext
),
    HomeComponent,
    KoinComponent {

    private val navbarManager: NavbarManager by inject()
    private val drawerManager: DrawerManager by inject()

    private val scope: CoroutineScope = coroutineScope()

    private val topbar: HomeTopbar = HomeTopbar(
        component = get<TopbarComponent> {
            parametersOf(childContext(key = TOPBAR_KEY))
        }
    )

    private val navbar: HomeNavbar = HomeNavbar(
        component = get<NavbarComponent> {
            parametersOf(childContext(key = NAVBAR_KEY))
        }
    )

    private val pagesNavigation = PagesNavigation<HomePageConfig>()

    private val pages: Value<ChildPages<HomePageConfig, HomePage>> = childPages(
        source = pagesNavigation,
        serializer = HomePageConfig.serializer(),
        initialPages = { Pages() },
        key = PAGES_KEY,
        handleBackButton = false,
        childFactory = ::pageFactory
    )

    private val drawerNavigation = DrawerNavigation()

    private val drawer: Value<ChildDrawer<HomeDrawer>> = childDrawer(
        source = drawerNavigation,
        key = DRAWER_KEY,
        childFactory = ::drawerFactory
    )

    init {
        observeNavbarItems()
        observeNavbarActiveItemIndex()
        observeDrawerState()
    }

    @Composable
    override fun Render() {
        HomeScreen(
            topbar = topbar,
            navbar = navbar,
            pages = pages,
            drawer = drawer,
            onIntent = ::handleIntent
        )
    }

    @OptIn(ExperimentalDecomposeApi::class)
    private fun observeNavbarItems() = navbarManager.items.onEach { items ->
        pagesNavigation.setItems {
            items.map { item ->
                when (item) {
                    NavbarItem.DASHBOARD -> HomePageConfig.Dashboard
                    NavbarItem.SEARCH -> HomePageConfig.Search
                }
            }
        }
    }.launchIn(scope)

    private fun observeNavbarActiveItemIndex() = navbarManager.activeItemIndex.onEach { activeItem ->
        pagesNavigation.select(index = activeItem)
    }.launchIn(scope)

    private fun observeDrawerState() = drawerManager.isOpened.onEach { isOpened ->
        if (isOpened) {
            drawerNavigation.open()
        } else {
            drawerNavigation.close()
        }
    }.launchIn(scope)

    private fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.OnDrawerStateChanged -> onDrawerStateChanged(isOpen = intent.isOpen)
        }
    }

    private fun onDrawerStateChanged(isOpen: Boolean) {
        if (isOpen) {
            drawerManager.open()
        } else {
            drawerManager.close()
        }
    }

    private fun pageFactory(
        config: HomePageConfig,
        componentContext: ComponentContext
    ): HomePage {
        return when (config) {
            is HomePageConfig.Dashboard -> {
                HomePage.Dashboard(
                    component = get<DashboardComponent> { parametersOf(componentContext) }
                )
            }

            is HomePageConfig.Search -> {
                HomePage.Search(
                    component = get<SearchComponent> { parametersOf(componentContext) }
                )
            }
        }
    }

    private fun drawerFactory(componentContext: ComponentContext): HomeDrawer {
        return HomeDrawer(
            component = get<DrawerComponent> { parametersOf(componentContext) }
        )
    }

    private companion object {
        const val PAGES_KEY = "pages"
        const val NAVBAR_KEY = "navbar"
        const val TOPBAR_KEY = "topbar"
        const val DRAWER_KEY = "drawer"
    }
}
