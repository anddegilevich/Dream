package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.foundation.decompose.component.store.storeFactory.ComponentStoreFactoryAbs
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ProfileStoreFactory(
    storeFactory: StoreFactory
) : ComponentStoreFactoryAbs<ProfileState, ProfileIntent, ProfileSideEffect>(
    storeFactory = storeFactory,
    storeName = ProfileStore::class.className(),
    executorFactory = { lifecycle ->
        ProfileExecutor(lifecycle = lifecycle)
    }
)