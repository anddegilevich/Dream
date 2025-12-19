package and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

class NavbarUIStatePreviewProvider : PreviewParameterProvider<NavbarUIState> {

    override val values: Sequence<NavbarUIState> = sequenceOf(
        provide()
    )

    fun provide(): NavbarUIState {
        return NavbarUIState(
            items = NavbarItemUIDataPreviewProvider().provideList()
        )
    }
}