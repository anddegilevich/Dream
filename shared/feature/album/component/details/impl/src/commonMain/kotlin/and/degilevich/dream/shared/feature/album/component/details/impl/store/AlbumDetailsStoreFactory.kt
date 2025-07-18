package and.degilevich.dream.shared.feature.album.component.details.impl.store

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.impl.BaseComponentStoreFactory

internal class AlbumDetailsStoreFactory : BaseComponentStoreFactory<
    AlbumDetailsState,
    AlbumDetailsIntent,
    AlbumDetailsSideEffect
    >(
    storeName = AlbumDetailsStore::class.className(),
    executorFactory = { lifecycle -> AlbumDetailsExecutor(lifecycle = lifecycle) }
)