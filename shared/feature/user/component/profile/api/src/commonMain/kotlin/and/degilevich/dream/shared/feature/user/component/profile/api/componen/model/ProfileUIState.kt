package and.degilevich.dream.shared.feature.user.component.profile.api.componen.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Immutable
data class ProfileUIState(
    val iconUri: String = "",
    val profilePhotos: ImmutableList<ProfilePhotoUIData> = persistentListOf()
)
