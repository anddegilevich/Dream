package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistInfoLayoutUIData
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shated.feature.track.design.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsUIStateMapper : Mapper<ArtistDetailsState, ArtistDetailsUIState>, KoinComponent {

    private val trackInfoToTrackCardUIDataMapper: TrackInfoToTrackCardUIDataMapper by inject()
    private val albumInfoToCardUIDataMapper: AlbumInfoToCardUIDataMapper by inject()

    override fun map(item: ArtistDetailsState): ArtistDetailsUIState {
        return with(item) {
            ArtistDetailsUIState(
                info = mapToInfo(state = item),
                topTracks = mapToTopTracks(state = item),
                albums = mapToAlbums(state = item)
            )
        }
    }

    private fun mapToInfo(state: ArtistDetailsState): Skeleton<ArtistInfoLayoutUIData> {
        return with(state) {
            if (artist.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    ArtistInfoLayoutUIData(
                        iconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                        name = artist.name,
                    )
                )
            }
        }
    }

    private fun mapToTopTracks(state: ArtistDetailsState): Skeleton<ImmutableList<TrackCardUIData>> {
        return with(state) {
            if (topTracks.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    topTracks
                        .asSequence()
                        .sortedBy { track -> track.popularity }
                        .mapWith(trackInfoToTrackCardUIDataMapper)
                        .mapIndexed { index, cardData ->
                            cardData.copy(
                                number = index.inc().toString()
                            )
                        }
                        .toImmutableList()
                )
            }
        }
    }

    private fun mapToAlbums(state: ArtistDetailsState): Skeleton<ImmutableList<AlbumCardUIData>> {
        return with(state) {
            if (albums.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    albums
                        .asSequence()
                        .sortedBy { album -> album.releaseDate }
                        .mapWith(albumInfoToCardUIDataMapper)
                        .toImmutableList(),
                )
            }
        }
    }
}