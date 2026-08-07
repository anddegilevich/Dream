package and.degilevich.dream.shared.feature.common.home.impl.view

import and.degilevich.dream.shared.design.system.stub.ViewStub
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.impl.view.semantic.HomeScreenSemantic
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.v2.runComposeUiTest
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.value.MutableValue
import kotlin.test.Test
import com.arkivanov.decompose.router.pages.ChildPages as ChildPagesState

@OptIn(ExperimentalTestApi::class)
class HomeScreenTest {

    private val page = hasTestTag(HomeScreenSemantic.TEST_TAG_PAGE)

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                HomeScreen(
                    navbar = HomeNavbar(
                        component = object : NavbarComponent {
                            @Composable
                            override fun Render() {
                                ViewStub(stub = "NavbarComponent")
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
        }
        onAllNodes(page)
            .onFirst()
            .assertIsDisplayed()
    }
}
