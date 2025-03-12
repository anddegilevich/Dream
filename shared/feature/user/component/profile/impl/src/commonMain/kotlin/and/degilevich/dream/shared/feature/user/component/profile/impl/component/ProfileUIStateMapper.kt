package and.degilevich.dream.shared.feature.user.component.profile.impl.component

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileUIState
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class ProfileUIStateMapper : Mapper<ProfileState, ProfileUIState> {
    override fun map(item: ProfileState): ProfileUIState {
        return ProfileUIState(
            iconUrl = item.iconUrl
        )
    }
}