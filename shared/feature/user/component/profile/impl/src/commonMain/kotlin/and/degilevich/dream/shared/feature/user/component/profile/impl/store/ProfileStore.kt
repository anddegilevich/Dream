package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import com.arkivanov.mvikotlin.core.store.Store

internal interface ProfileStore : Store<ProfileIntent, ProfileState, ProfileSideEffect>