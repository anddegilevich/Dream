package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.ComponentStoreFactoryTemplate

internal class ProfileStoreFactory : ComponentStoreFactoryTemplate<ProfileState, ProfileIntent, ProfileSideEffect>(
    storeName = ProfileStore::class.className(),
    executorFactory = { lifecycle ->
        ProfileExecutor(lifecycle = lifecycle)
    }
)