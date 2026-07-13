package and.degilevich.dream.shared.feature.common.component.navbar.impl.preview

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.view.AppNavbar
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewMVIComponent
import androidx.compose.runtime.Composable

class NavbarPreviewComponent :
    PreviewMVIComponent<NavbarUIState, NavbarIntent, NavbarSideEffect>(
        state = NavbarUIStatePreviewProvider().provideDefault()
    ),
    NavbarComponent {

    @Composable
    override fun Render() {
        AppNavbar(
            state = state(),
            onIntent = ::handleIntent
        )
    }
}
