package and.degilevich.dream.shared.feature.common.home.api.component

import and.degilevich.dream.shared.feature.common.home.api.component.child.HomeNavbar
import and.degilevich.dream.shared.feature.common.home.api.component.child.HomePage
import and.degilevich.dream.shared.feature.common.home.api.component.model.HomePageConfig
import and.degilevich.dream.shared.feature.common.home.api.design.HomeScreen
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.pages.ChildPages
import com.arkivanov.decompose.value.Value

@Stable
interface HomeComponent : RenderComponent {
    val navbar: HomeNavbar
    val pages: Value<ChildPages<HomePageConfig, HomePage>>

    @Composable
    override fun Render(modifier: Modifier) {
        HomeScreen(
            modifier = modifier,
            component = this
        )
    }
}