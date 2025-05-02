package and.degilevich.dream.shared.feature.user.component.profile.api.componen.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ProfileUIState(
    val iconUri: String,
    val profilePhotos: ImmutableList<ProfilePhotoUIData>
) {
    companion object : EmptyFactory<ProfileUIState> {
        override fun empty(): ProfileUIState {
            return ProfileUIState(
                iconUri = "",
                profilePhotos = persistentListOf()
            )
        }
    }
}
