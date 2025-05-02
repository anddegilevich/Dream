package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class ProfileStateConservator : StoreStateConservator<ProfileState> {
    override val key: String = ProfileState::class.className()
    override val initialState: ProfileState = ProfileState(
        iconUri = "",
        profilePhotosUris = emptyList()
    )
    override val serializer: KSerializer<ProfileState> = ProfileState.serializer()
}