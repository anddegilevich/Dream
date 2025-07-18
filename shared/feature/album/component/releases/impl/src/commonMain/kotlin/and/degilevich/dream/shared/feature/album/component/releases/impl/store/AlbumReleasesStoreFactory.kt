package and.degilevich.dream.shared.feature.album.component.releases.impl.store

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.template.component.impl.BaseComponentStoreFactory

internal class AlbumReleasesStoreFactory : BaseComponentStoreFactory<
    AlbumReleasesState,
    AlbumReleasesIntent,
    AlbumReleasesSideEffect
    >(
    storeName = AlbumReleasesStore::class.className(),
    executorFactory = { lifecycle -> AlbumReleasesExecutor(lifecycle = lifecycle) }
)