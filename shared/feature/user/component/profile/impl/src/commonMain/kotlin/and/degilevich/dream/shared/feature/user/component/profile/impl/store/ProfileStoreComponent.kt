package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.template.component.DreamStoreComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ProfileStoreComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
) : DreamStoreComponent<ProfileState, ProfileIntent, ProfileSideEffect>(
    componentContext = componentContext,
    storeFactory = ProfileStoreFactory(storeFactory = storeFactory),
    stateConservator = ProfileStateConservator()
)