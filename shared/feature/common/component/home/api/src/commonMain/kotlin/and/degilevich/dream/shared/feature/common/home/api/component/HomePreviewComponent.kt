package and.degilevich.dream.shared.feature.common.home.api.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardPreviewComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarPreviewComponent
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.api.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.api.design.HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

@OptIn(ExperimentalDecomposeApi::class)
class HomePreviewComponent : HomeComponent {

    override val navbar: HomeNavbar = HomeNavbar(
        component = NavbarPreviewComponent()
    )

    override val pages: Value<ChildPages<HomePageConfig, HomePage>> = MutableValue(
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
    override fun Render(modifier: Modifier) {
        HomeScreen(
            modifier = modifier,
            component = this
        )
    }
}