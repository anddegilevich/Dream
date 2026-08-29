package and.degilevich.dream.shared.feature.user.ui.api.preview

import and.degilevich.dream.shared.feature.user.ui.api.model.UserAvatarUIData
import and.degilevich.dream.shared.foundation.compose.preview.LabeledPreviewParameterProvider

class UserAvatarUIDataPreviewProvider : LabeledPreviewParameterProvider<UserAvatarUIData>() {

    override val labeledValues = listOf(
        "Default" to provideDefault(),
        "Placeholder" to provideLetterOnly(),
    )

    fun provideDefault(): UserAvatarUIData {
        return UserAvatarUIData(
            url = "https://image.url/avatar.jpg",
            firstLetter = "U"
        )
    }

    fun provideLetterOnly(): UserAvatarUIData {
        return UserAvatarUIData.empty().copy(
            firstLetter = "U"
        )
    }
}
