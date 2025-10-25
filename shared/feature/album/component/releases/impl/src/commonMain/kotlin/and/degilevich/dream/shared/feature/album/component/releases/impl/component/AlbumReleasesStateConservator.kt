package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class AlbumReleasesStateConservator : ComponentStateConservator<AlbumReleasesState> {
    override val key: String = AlbumReleasesState::class.className()
    override val initialState: AlbumReleasesState = AlbumReleasesState(
        isLoading = true,
        releases = emptyList()
    )
    override val serializer: KSerializer<AlbumReleasesState> = AlbumReleasesState.serializer()
}