package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shated.feature.track.design.api.mapper.TrackInfoToTrackCardUIDataMapper
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsUIStateMapper : Mapper<ArtistDetailsState, ArtistDetailsUIState>, KoinComponent {

    private val trackInfoToTrackCardUIDataMapper: TrackInfoToTrackCardUIDataMapper by inject()
    private val albumInfoToCardUIDataMapper: AlbumInfoToCardUIDataMapper by inject()

    override fun map(item: ArtistDetailsState): ArtistDetailsUIState {
        return with(item) {
            ArtistDetailsUIState(
                iconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                name = artist.name,
                topTracks = topTracks
                    .asSequence()
                    .sortedBy { track -> track.popularity }
                    .mapWith(trackInfoToTrackCardUIDataMapper)
                    .toImmutableList(),
                albums = albums
                    .asSequence()
                    .sortedBy { album -> album.releaseDate }
                    .mapWith(albumInfoToCardUIDataMapper)
                    .toImmutableList(),
            )
        }
    }
}