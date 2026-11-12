package and.degilevich.dream.shared.feature.common.home.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponentFactory
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponentFactory
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerManager
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponentFactory
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarManager
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItem
import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponentFactory
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeDrawer
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeMiniPlayer
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeTopbar
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomeIntent
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomeMiniPlayerConfig
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.impl.view.HomeScreen
import and.degilevich.dream.shared.feature.player.component.miniPlayer.api.component.MiniPlayerComponentFactory
import and.degilevich.dream.shared.feature.player.domain.api.manager.PlayerManager
import and.degilevich.dream.shared.feature.player.domain.model.core.api.data.PlayerStateData
import and.degilevich.dream.shared.feature.search.component.search.api.component.SearchComponentFactory
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.ChildDrawer
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.DrawerNavigation
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.childDrawer
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
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class HomeComponentImpl(
    componentContext: ComponentContext
) : BaseComponent(
    componentContext = componentContext
),
    HomeComponent,
    KoinComponent {

    private val navbarManager: NavbarManager by inject()
    private val drawerManager: DrawerManager by inject()
    private val playerManager: PlayerManager by inject()
    private val topbarComponentFactory: TopbarComponentFactory by inject()
    private val navbarComponentFactory: NavbarComponentFactory by inject()
    private val dashboardComponentFactory: DashboardComponentFactory by inject()
    private val searchComponentFactory: SearchComponentFactory by inject()
    private val drawerComponentFactory: DrawerComponentFactory by inject()
    private val miniPlayerComponentFactory: MiniPlayerComponentFactory by inject()

    private val scope: CoroutineScope = coroutineScope()

    private val topbar: HomeTopbar = HomeTopbar(
        component = topbarComponentFactory.create(
            componentContext = childContext(key = TOPBAR_KEY)
        )
    )

    private val navbar: HomeNavbar = HomeNavbar(
        component = navbarComponentFactory.create(
            componentContext = childContext(key = NAVBAR_KEY)
        )
    )

    private val miniPlayerNavigation = SlotNavigation<HomeMiniPlayerConfig>()

    private val miniPlayer: Value<ChildSlot<HomeMiniPlayerConfig, HomeMiniPlayer>> = childSlot(
        source = miniPlayerNavigation,
        serializer = HomeMiniPlayerConfig.serializer(),
        key = MINI_PLAYER_KEY,
        handleBackButton = false,
        childFactory = { _, componentContext ->
            miniPlayerFactory(componentContext = componentContext)
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
        observePlayerState()
    }

    @Composable
    override fun Render() {
        HomeScreen(
            topbar = topbar,
            navbar = navbar,
            miniPlayer = miniPlayer,
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

    private fun observePlayerState() = playerManager.playerState
        .flowOn(Dispatchers.IO)
        .map { playerState -> playerState is PlayerStateData.Active }
        .distinctUntilChanged()
        .onEach { isActive ->
            if (isActive) {
                miniPlayerNavigation.activate(configuration = HomeMiniPlayerConfig)
            } else {
                miniPlayerNavigation.dismiss()
            }
        }
        .launchIn(scope)

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
                    component = dashboardComponentFactory.create(
                        componentContext = componentContext
                    )
                )
            }

            is HomePageConfig.Search -> {
                HomePage.Search(
                    component = searchComponentFactory.create(
                        componentContext = componentContext
                    )
                )
            }
        }
    }

    private fun drawerFactory(componentContext: ComponentContext): HomeDrawer {
        return HomeDrawer(
            component = drawerComponentFactory.create(
                componentContext = componentContext
            )
        )
    }

    private fun miniPlayerFactory(
        componentContext: ComponentContext
    ): HomeMiniPlayer {
        return HomeMiniPlayer(
            component = miniPlayerComponentFactory.create(
                componentContext = componentContext
            )
        )
    }

    private companion object {
        const val PAGES_KEY = "pages"
        const val NAVBAR_KEY = "navbar"
        const val TOPBAR_KEY = "topbar"
        const val DRAWER_KEY = "drawer"
        const val MINI_PLAYER_KEY = "mini_player"
    }
}
