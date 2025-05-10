package and.degilevich.dream.shared.feature.user.component.profile.impl.component

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.ProfileComponent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileUIState
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.ProfileStoreComponent
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.template.component.impl.UIStoreComponentTemplate
import com.arkivanov.decompose.ComponentContext

class ProfileComponentImpl(
    componentContext: ComponentContext
) : UIStoreComponentTemplate<ProfileUIState, ProfileIntent, ProfileSideEffect, ProfileState>(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        ProfileStoreComponent(
            componentContext = childComponentContext
        )
    },
    uiStateMapper = ProfileUIStateMapper(),
    initialUIState = ProfileUIState.empty()
),
    ProfileComponent