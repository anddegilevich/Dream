package and.degilevich.dream.shared.feature.common.home.impl.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.system.stub.ViewStub
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomePageConfig
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.pages.ChildPages
import com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.router.pages.ChildPages as ChildPagesState

@Composable
fun HomeScreen(
    navbar: HomeNavbar,
    pages: Value<ChildPagesState<HomePageConfig, HomePage>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
    ) {
        ChildPages(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            pages = pages,
            onPageSelected = { },
            pager = { pagerModifier, state, key, pageContent ->
                HorizontalPager(
                    modifier = pagerModifier,
                    state = state,
                    key = key,
                    pageContent = pageContent,
                    userScrollEnabled = false
                )
            },
            key = { child -> child.configuration.id.value },
            scrollAnimation = PagesScrollAnimation.Default,
        ) { _, page ->
            page.Render()
        }
        navbar.Render()
    }
}

@LightDarkPreviews
@Composable
private fun HomeScreenPreview() = ComposeAppTheme {
    HomeScreen(
        navbar = HomeNavbar(
            component = object : NavbarComponent {
                @Composable
                override fun Render() {
                    ViewStub(
                        modifier = Modifier.height(44.dp),
                        stub = "NavbarComponent",
                    )
                }
            }
        ),
        pages = MutableValue(
            ChildPagesState(
                items = listOf(
                    Child.Created(
                        configuration = HomePageConfig.Dashboard,
                        instance = HomePage.Dashboard(
                            component = object : DashboardComponent {

                                @Composable
                                override fun Render() {
                                    ViewStub(stub = "DashboardComponent")
                                }
                            }
                        ),
                        key = "dashboard"
                    )
                ),
                selectedIndex = 0
            )
        )
    )
}