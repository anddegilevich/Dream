package and.degilevich.dream.shared.feature.user.component.profile.api.componen

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileUIState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.MVIComponent

interface ProfileComponent : MVIComponent<ProfileUIState, ProfileIntent, ProfileSideEffect>