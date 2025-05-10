package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.template.component.impl.StoreComponentTemplate
import com.arkivanov.decompose.ComponentContext

internal class ProfileStoreComponent(
    componentContext: ComponentContext
) : StoreComponentTemplate<ProfileState, ProfileIntent, ProfileSideEffect>(
    componentContext = componentContext,
    storeFactory = ProfileStoreFactory(),
    stateConservator = ProfileStateConservator()
)