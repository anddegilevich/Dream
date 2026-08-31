package and.degilevich.dream.shared.feature.common.home.impl.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
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
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import and.degilevich.dream.shared.foundation.decompose.compose.drawer.rememberNavigationDrawerState
import and.degilevich.dream.shared.foundation.decompose.navigation.drawer.ChildDrawer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.ModalDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.Child
import com.arkivanov.decompose.extensions.compose.pages.ChildPages
import com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.router.pages.ChildPages as ChildPagesState

@Composable
fun HomeScreen(
    topbar: HomeTopbar,
    navbar: HomeNavbar,
    pages: Value<ChildPagesState<HomePageConfig, HomePage>>,
    drawer: Value<ChildDrawer<HomeDrawer>>,
    modifier: Modifier = Modifier,
    onIntent: (HomeIntent) -> Unit
) {
    val navigationDrawerState = rememberNavigationDrawerState(
        drawer = drawer,
        onStateChanged = { isOpen ->
            onIntent(HomeIntent.OnDrawerStateChanged(isOpen = isOpen))
        }
    )

    ModalDrawer(
        modifier = modifier.fillMaxSize(),
        drawerState = navigationDrawerState.drawerState,
        gesturesEnabled = navigationDrawerState.drawerState.isOpen,
        drawerContent = {
            Box(
                modifier = Modifier
                    .testTag(HomeScreenSemantic.TEST_TAG_DRAWER)
                    .fillMaxHeight()
            ) {
                navigationDrawerState.instance.Render()
            }
        }
    ) {
        HomeContent(
            topbar = topbar,
            navbar = navbar,
            pages = pages
        )
    }
}

@Composable
private fun HomeContent(
    topbar: HomeTopbar,
    navbar: HomeNavbar,
    pages: Value<ChildPagesState<HomePageConfig, HomePage>>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
    ) {
        topbar.Render()
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
            Box(
                modifier = Modifier.testTag(HomeScreenSemantic.TEST_TAG_PAGE)
            ) {
                page.Render()
            }
        }
        navbar.Render()
    }
}

@LightDarkPreviews
@Composable
private fun HomeScreenPreview() = ComposeAppTheme {
    HomeScreen(
        topbar = HomeTopbar(
            component = object : TopbarComponent {
                @Composable
                override fun Render() {
                    ViewStub(
                        modifier = Modifier.height(56.dp),
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
        drawer = MutableValue(
            ChildDrawer(
                instance = HomeDrawer(
                    component = object : DrawerComponent {
                        @Composable
                        override fun Render() {
                            ViewStub(stub = "DrawerComponent")
                        }
                    }
                ),
                isOpen = false
            )
        ),
        onIntent = { }
    )
}
