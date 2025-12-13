package and.degilevich.dream.shared.feature.common.home.impl.component

import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.DashboardComponentImpl
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.NavbarComponentImpl
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.api.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.search.component.search.impl.component.SearchComponentImpl
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orNullIfNegative
import and.degilevich.dream.shared.template.component.impl.BaseComponent
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

    override val navbar: HomeNavbar = HomeNavbar(
        component = NavbarComponentImpl(
            componentContext = childContext(key = "navbar")
        )
    )

    private val pagesNavigation = PagesNavigation<HomePageConfig>()

    override val pages: Value<ChildPages<HomePageConfig, HomePage>> = childPages(
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
        key = "pages",
        handleBackButton = false,
        childFactory = ::pageFactory
    )

    init {
        observeNavbarState()
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
        navbar.state.collectLatest { state ->
            val activePageIndex = state.items.indexOfFirst { item ->
                item.isSelected
            }.orNullIfNegative() ?: return@collectLatest
            pagesNavigation.select(
                index = activePageIndex
            )
        }
    }
}