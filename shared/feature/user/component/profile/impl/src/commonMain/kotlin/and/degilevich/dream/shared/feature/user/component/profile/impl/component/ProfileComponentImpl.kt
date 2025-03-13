package and.degilevich.dream.shared.feature.user.component.profile.impl.component

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.ProfileComponent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileUIState
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.ProfileStoreComponent
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.template.component.DreamUIStoreComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

class ProfileComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : DreamUIStoreComponent<ProfileUIState, ProfileIntent, ProfileSideEffect, ProfileState>(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        ProfileStoreComponent(
            componentContext = childComponentContext,
            storeFactory = storeFactory
        )
    },
    uiStateMapper = ProfileUIStateMapper(),
    initialUIState = ProfileUIState()
),
    ProfileComponent