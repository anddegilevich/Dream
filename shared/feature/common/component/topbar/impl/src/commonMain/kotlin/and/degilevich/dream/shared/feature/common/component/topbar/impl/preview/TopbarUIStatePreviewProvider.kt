package and.degilevich.dream.shared.feature.common.component.topbar.impl.preview

import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarUIState
import and.degilevich.dream.shared.feature.user.ui.api.preview.UserAvatarUIDataPreviewProvider
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class TopbarUIStatePreviewProvider : LabeledPreviewParameterProvider<TopbarUIState>() {

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Loading" to provideLoading()
    )

    fun provideDefault(): TopbarUIState {
        return TopbarUIState(
            avatar = Skeleton.Value(UserAvatarUIDataPreviewProvider().provideDefault())
        )
    }

    fun provideLoading(): TopbarUIState {
        return TopbarUIState(
            avatar = Skeleton.Loading
        )
    }
}
