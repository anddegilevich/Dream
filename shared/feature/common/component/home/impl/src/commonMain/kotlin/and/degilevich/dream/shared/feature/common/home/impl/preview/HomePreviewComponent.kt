package and.degilevich.dream.shared.feature.common.home.impl.preview

import and.degilevich.dream.shared.feature.common.component.dashboard.impl.preview.DashboardPreviewComponent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.preview.NavbarPreviewComponent
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.impl.view.HomeScreen
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

@OptIn(ExperimentalDecomposeApi::class)
class HomePreviewComponent : HomeComponent {

    private val navbar: HomeNavbar = HomeNavbar(
        component = NavbarPreviewComponent()
    )

    private val pages: Value<ChildPages<HomePageConfig, HomePage>> = MutableValue(
        ChildPages(
            items = listOf(
                Child.Created(
                    configuration = HomePageConfig.Dashboard,
                    instance = HomePage.Dashboard(
                        component = DashboardPreviewComponent()
                    ),
                    key = "dashboard"
                )
            ),
            selectedIndex = 0
        )
    )

    @Composable
    override fun Render() {
        HomeScreen(navbar = navbar, pages = pages)
    }
}
