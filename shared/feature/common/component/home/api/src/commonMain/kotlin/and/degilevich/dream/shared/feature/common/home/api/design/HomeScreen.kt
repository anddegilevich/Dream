package and.degilevich.dream.shared.feature.common.home.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.common.component.dashboard.api.design.DashboardScreen
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.AppNavbar
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomePage
import and.degilevich.dream.shared.feature.search.component.search.api.design.SearchScreen
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.pages.ChildPages
import com.arkivanov.decompose.extensions.compose.pages.PagesScrollAnimation

@Composable
fun HomeScreen(
    component: HomeComponent,
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
            pages = component.pages,
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
            key = { child -> child.configuration.id.id },
            scrollAnimation = PagesScrollAnimation.Default,
        ) { _, page ->
            when (page) {
                is HomePage.Dashboard -> {
                    DashboardScreen(
                        component = page
                    )
                }

                is HomePage.Search -> {
                    SearchScreen(
                        state = page.state(),
                        onIntent = page::handleIntent
                    )
                }
            }
        }
        AppNavbar(
            modifier = Modifier.navigationBarsPadding(),
            state = component.navbar.state(),
            onIntent = component.navbar::handleIntent
        )
    }
}