package and.degilevich.dream.shared.feature.common.home.impl.view

import and.degilevich.dream.shared.design.system.stub.ViewStub
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.topbar.api.component.TopbarComponent
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeDrawer
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.impl.component.child.HomeTopbar
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomeIntent
import and.degilevich.dream.shared.feature.common.home.impl.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.impl.view.semantic.HomeScreenSemantic
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.ChildDrawer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.v2.runComposeUiTest
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test
import com.arkivanov.decompose.router.pages.ChildPages as ChildPagesState

@OptIn(ExperimentalTestApi::class)
class HomeScreenTest {

    private val page = hasTestTag(HomeScreenSemantic.TEST_TAG_PAGE)
    private val topbar = hasTestTag(STUB_TEST_TAG_TOPBAR)
    private val drawerContent = hasTestTag(STUB_TEST_TAG_DRAWER)

    @Test
    fun `render closed drawer - shows topbar and selected page`() = runComposeUiTest {
        setContent(drawer = drawer(isOpen = false))
        onAllNodes(page)
            .onFirst()
            .assertIsDisplayed()
        onNode(topbar).assertIsDisplayed()
        onNode(drawerContent).assertIsNotDisplayed()
    }

    @Test
    fun `render opened drawer - shows drawer content`() = runComposeUiTest {
        setContent(drawer = drawer(isOpen = true))
        onNode(drawerContent).assertIsDisplayed()
    }

    @Test
    fun `render opened drawer - emits OnDrawerStateChanged with opened state`() = runComposeUiTest {
        val intents = mutableListOf<HomeIntent>()
        setContent(
            drawer = drawer(isOpen = true),
            onIntent = intents::add
        )
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(HomeIntent.OnDrawerStateChanged(isOpen = true))
    }

    private fun ComposeUiTest.setContent(
        drawer: Value<ChildDrawer<HomeDrawer>>,
        onIntent: (HomeIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            HomeScreen(
                topbar = HomeTopbar(
                    component = object : TopbarComponent {
                        @Composable
                        override fun Render() {
                            ViewStub(
                                modifier = Modifier
                                    .height(56.dp)
                                    .testTag(STUB_TEST_TAG_TOPBAR),
                                stub = "TopbarComponent"
                            )
                        }
                    }
                ),
                navbar = HomeNavbar(
                    component = object : NavbarComponent {
                        @Composable
                        override fun Render() {
                            ViewStub(
                                modifier = Modifier.height(44.dp),
                                stub = "NavbarComponent"
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
                ),
                drawer = drawer,
                onIntent = onIntent
            )
        }
    }

    private fun drawer(isOpen: Boolean): Value<ChildDrawer<HomeDrawer>> {
        return MutableValue(
            ChildDrawer(
                instance = HomeDrawer(
                    component = object : DrawerComponent {
                        @Composable
                        override fun Render() {
                            ViewStub(
                                modifier = Modifier.testTag(STUB_TEST_TAG_DRAWER),
                                stub = "DrawerComponent"
                            )
                        }
                    }
                ),
                isOpen = isOpen
            )
        )
    }
}

private const val STUB_TEST_TAG_TOPBAR = "stub_topbar"
private const val STUB_TEST_TAG_DRAWER = "stub_drawer"
