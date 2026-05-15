package and.degilevich.dream.shared.feature.search.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.api.local.AlbumLocalDataSource
import and.degilevich.dream.shared.feature.artist.data.api.local.ArtistLocalDataSource
import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult
import and.degilevich.dream.shared.feature.search.data.api.remote.SearchRemoteDataSource
import and.degilevich.dream.shared.feature.track.data.api.local.TrackLocalDataSource

internal class SearchUseCaseImpl(
    private val searchRemoteDataSource: SearchRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val albumLocalDataSource: AlbumLocalDataSource,
    private val trackLocalDataSource: TrackLocalDataSource
) : SearchUseCase {

    override suspend fun invoke(params: SearchParams): Result<SearchResult> {
        return searchRemoteDataSource.search(params = params).onSuccess { result ->
            artistLocalDataSource.saveArtists(artists = result.artists.items)
            albumLocalDataSource.saveAlbums(albums = result.albums.items)
            trackLocalDataSource.saveTracks(tracks = result.tracks.items)
        }
    }
}
