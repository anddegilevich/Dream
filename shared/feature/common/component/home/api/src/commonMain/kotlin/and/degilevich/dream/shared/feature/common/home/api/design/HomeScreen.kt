package and.degilevich.dream.shared.feature.common.home.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.common.home.api.component.HomePreviewComponent
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
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
            page.Render()
        }
        component.navbar.Render(modifier = Modifier.navigationBarsPadding())
    }
}

@LightDarkPreviews
@Composable
private fun HomeScreenPreview() = ComposeAppTheme {
    HomeScreen(
        component = HomePreviewComponent()
    )
}