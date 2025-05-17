package and.degilevich.dream.shared.feature.album.component.releases.impl.store

import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class AlbumReleasesStateConservator : StoreStateConservator<AlbumReleasesState> {
    override val key: String = AlbumReleasesState::class.className()
    override val initialState: AlbumReleasesState = AlbumReleasesState(
        isLoading = true,
        releases = emptyList()
    )
    override val serializer: KSerializer<AlbumReleasesState> = AlbumReleasesState.serializer()
}