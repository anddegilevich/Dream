package and.degilevich.dream.shared.feature.common.home.api.preview.component

import and.degilevich.dream.shared.feature.common.component.dashboard.api.preview.component.DashboardPreviewComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.preview.component.NavbarPreviewComponent
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.api.component.model.HomePageConfig
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
}