package and.degilevich.dream.shared.feature.common.component.navbar.api.component

import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.api.provider.NavbarUIStatePreviewProvider
import and.degilevich.dream.shared.foundation.decompose.compose.preview.PreviewMVIComponent

class NavbarPreviewComponent :
    PreviewMVIComponent<NavbarUIState, NavbarIntent, NavbarSideEffect>(
        state = NavbarUIStatePreviewProvider().provide()
    ),
    NavbarComponent