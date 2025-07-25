package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumTypeToUITextMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToLabelUIDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shated.feature.track.design.api.mapper.TrackInfoToTrackCardUIDataMapper
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AlbumDetailsUIStateMapper : Mapper<AlbumDetailsState, AlbumDetailsUIState>, KoinComponent {

    private val artistDataToLabelUIDataMapper: ArtistDataToLabelUIDataMapper by inject()
    private val trackInfoToTrackCardUIDataMapper: TrackInfoToTrackCardUIDataMapper by inject()
    private val albumTypeToUITextMapper: AlbumTypeToUITextMapper by inject()

    override fun map(item: AlbumDetailsState): AlbumDetailsUIState {
        return with(item) {
            AlbumDetailsUIState(
                name = album.name,
                iconUrl = album.images.firstOrNull()?.url.orEmpty(),
                artists = artists.mapWith(artistDataToLabelUIDataMapper).toImmutableList(),
                type = albumTypeToUITextMapper.map(album.albumType),
                year = album.releaseDate.take(YEAR_LENGTH), // FIXME: Parse and format date
                tracks = album.tracks.items
                    .asSequence()
                    .sortedBy { track -> track.trackNumber }
                    .mapWith(trackInfoToTrackCardUIDataMapper)
                    .toImmutableList()
            )
        }
    }

    private companion object {
        const val YEAR_LENGTH = 4
    }
}