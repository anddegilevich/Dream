package and.degilevich.dream.shared.feature.common.home.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.DashboardComponentImpl
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.NavbarComponentImpl
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.impl.view.HomeScreen
import and.degilevich.dream.shared.feature.search.component.search.impl.component.SearchComponentImpl
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orNullIfNegative
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.router.pages.Pages
import com.arkivanov.decompose.router.pages.PagesNavigation
import com.arkivanov.decompose.router.pages.childPages
import com.arkivanov.decompose.router.pages.select
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeComponentImpl(
    componentContext: ComponentContext
) : BaseComponent(
    componentContext = componentContext
),
    HomeComponent {

    private val scope = coroutineScope()

    private val navbarComponent = NavbarComponentImpl(
        componentContext = childContext(key = NAVBAR_KEY)
    )

    private val navbar: HomeNavbar = HomeNavbar(component = navbarComponent)

    private val pagesNavigation = PagesNavigation<HomePageConfig>()

    private val pages: Value<ChildPages<HomePageConfig, HomePage>> = childPages(
        source = pagesNavigation,
        serializer = HomePageConfig.serializer(),
        initialPages = {
            Pages(
                items = listOf(
                    HomePageConfig.Dashboard,
                    HomePageConfig.Search
                ),
                selectedIndex = 0
            )
        },
        key = PAGES_KEY,
        handleBackButton = false,
        childFactory = ::pageFactory
    )

    init {
        observeNavbarState()
    }

    @Composable
    override fun Render() {
        HomeScreen(navbar = navbar, pages = pages)
    }

    private fun pageFactory(
        config: HomePageConfig,
        componentContext: ComponentContext
    ): HomePage {
        return when (config) {
            is HomePageConfig.Dashboard -> {
                HomePage.Dashboard(
                    component = DashboardComponentImpl(
                        componentContext = componentContext
                    )
                )
            }

            is HomePageConfig.Search -> {
                HomePage.Search(
                    SearchComponentImpl(
                        componentContext = componentContext
                    )
                )
            }
        }
    }

    private fun observeNavbarState() = scope.launch {
        navbarComponent.state.collectLatest { state ->
            val activePageIndex = state.items.indexOfFirst { item ->
                item.isSelected
            }.orNullIfNegative() ?: return@collectLatest
            pagesNavigation.select(
                index = activePageIndex
            )
        }
    }

    private companion object {
        const val PAGES_KEY = "pages"
        const val NAVBAR_KEY = "navbar"
    }
}