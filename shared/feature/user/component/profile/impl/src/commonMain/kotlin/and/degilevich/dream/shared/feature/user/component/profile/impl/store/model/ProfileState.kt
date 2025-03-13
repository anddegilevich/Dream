package and.degilevich.dream.shared.feature.user.component.profile.impl.store.model

import kotlinx.serialization.Serializable

@Serializable
data class ProfileState(
    val iconUri: String = ""
)
