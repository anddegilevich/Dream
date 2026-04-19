package and.degilevich.dream.shared.feature.common.component.navbar.api.provider

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class NavbarUIStatePreviewProvider : LabeledPreviewParameterProvider<NavbarUIState>() {

    override val labeledValues = listOf(
        "Default" to provideDefault()
    )

    fun provideDefault(): NavbarUIState {
        return NavbarUIState(
            items = NavbarItemUIDataPreviewProvider().provideList()
        )
    }
}