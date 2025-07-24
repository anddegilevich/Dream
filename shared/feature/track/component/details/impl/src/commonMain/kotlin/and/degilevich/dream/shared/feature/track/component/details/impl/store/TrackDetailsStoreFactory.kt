package and.degilevich.dream.shared.feature.track.component.details.impl.store

import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsSideEffect
import and.degilevich.dream.shared.feature.track.component.details.impl.store.model.TrackDetailsState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.impl.BaseComponentStoreFactory

internal class TrackDetailsStoreFactory : BaseComponentStoreFactory<
    TrackDetailsState,
    TrackDetailsIntent,
    TrackDetailsSideEffect
    >(
    storeName = TrackDetailsStore::class.className(),
    executorFactory = { lifecycle -> TrackDetailsExecutor(lifecycle = lifecycle) }
)