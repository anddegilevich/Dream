package and.degilevich.dream.shared.feature.common.component.navbar.api.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.api.design.AppNavbar
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderMVIComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable

@Stable
interface NavbarComponent : RenderMVIComponent<NavbarUIState, NavbarIntent, NavbarSideEffect> {

    @Composable
    override fun Render() {
        AppNavbar(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}