package and.degilevich.dream.shared.feature.common.component.navbar.api.preview.provider

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState

object NavbarUIStatePreviewProvider {
    fun provide(): NavbarUIState {
        return NavbarUIState(
            isVisible = true,
            items = NavbarItemUIDataPreviewProvider.provideList()
        )
    }
}