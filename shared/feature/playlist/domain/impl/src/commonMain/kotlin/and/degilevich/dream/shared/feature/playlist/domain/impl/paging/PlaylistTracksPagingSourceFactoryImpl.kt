package and.degilevich.dream.shared.feature.playlist.domain.impl.paging

import and.degilevich.dream.shared.feature.playlist.domain.api.paging.PlaylistTracksPagingSource
import and.degilevich.dream.shared.feature.playlist.domain.api.paging.PlaylistTracksPagingSourceFactory
import and.degilevich.dream.shared.feature.playlist.domain.api.usecase.GetPlaylistTracksUseCase
import com.arkivanov.decompose.ComponentContext

internal class PlaylistTracksPagingSourceFactoryImpl(
    private val getPlaylistTracksUseCase: GetPlaylistTracksUseCase
) : PlaylistTracksPagingSourceFactory {

    override fun create(
        componentContext: ComponentContext
    ): PlaylistTracksPagingSource = PlaylistTracksPagingSourceImpl(
        componentContext = componentContext,
        getPlaylistTracksUseCase = getPlaylistTracksUseCase
    )
}
