package and.degilevich.dream.shared.feature.user.ui.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class UserAvatarUIData(
    val url: String,
    val firstLetter: String
) {

    companion object : EmptyFactory<UserAvatarUIData> {

        override fun empty(): UserAvatarUIData {
            return UserAvatarUIData(
                url = "",
                firstLetter = ""
            )
        }
    }
}
