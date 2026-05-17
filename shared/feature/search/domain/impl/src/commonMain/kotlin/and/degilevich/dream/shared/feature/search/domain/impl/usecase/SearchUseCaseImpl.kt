package and.degilevich.dream.shared.feature.search.domain.impl.usecase

import and.degilevich.dream.shared.feature.album.data.api.repository.AlbumRepository
import and.degilevich.dream.shared.feature.artist.data.api.repository.ArtistRepository
import and.degilevich.dream.shared.feature.search.data.api.repository.SearchRepository
import and.degilevich.dream.shared.feature.search.domain.api.usecase.SearchUseCase
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchParams
import and.degilevich.dream.shared.feature.search.model.core.method.search.SearchResult
import and.degilevich.dream.shared.feature.track.data.api.repository.TrackRepository

internal class SearchUseCaseImpl(
    private val searchRepository: SearchRepository,
    private val artistRepository: ArtistRepository,
    private val albumRepository: AlbumRepository,
    private val trackRepository: TrackRepository
) : SearchUseCase {

    override suspend fun invoke(params: SearchParams): Result<SearchResult> {
        return searchRepository.search(params = params).onSuccess { result ->
            artistRepository.cacheArtists(artists = result.artists.items)
            albumRepository.cacheAlbums(albums = result.albums.items)
            trackRepository.cacheTracks(tracks = result.tracks.items)
        }
    }
}
