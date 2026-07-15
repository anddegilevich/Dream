package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.core.datetime.api.DreamDateTimeFormat
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsLayoutUIData
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.ui.api.mapper.AlbumTypeToUITextMapper
import and.degilevich.dream.shared.feature.artist.ui.api.mapper.ArtistDataToLabelUIDataMapper
import and.degilevich.dream.shared.feature.artist.ui.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shated.feature.track.ui.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardUIData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AlbumDetailsUIStateMapper : Mapper<AlbumDetailsState, AlbumDetailsUIState>, KoinComponent {

    private val artistDataToLabelUIDataMapper: ArtistDataToLabelUIDataMapper by inject()
    private val trackInfoToTrackCardUIDataMapper: TrackInfoToTrackCardUIDataMapper by inject()
    private val albumTypeToUITextMapper: AlbumTypeToUITextMapper by inject()
    private val dateTime: DateTime by inject()

    override fun map(item: AlbumDetailsState): AlbumDetailsUIState = with(item) {
        AlbumDetailsUIState(
            info = mapToInfo(state = this),
            artists = mapToArtists(state = this),
            tracks = mapToTracks(state = this)
        )
    }

    private fun mapToInfo(state: AlbumDetailsState): Skeleton<AlbumDetailsLayoutUIData> = with(state) {
        Skeleton.from(
            isLoading = album.isEmpty()
        ) {
            AlbumDetailsLayoutUIData(
                iconUrl = album.images.firstOrNull()?.url.orEmpty(),
                name = album.name,
                type = albumTypeToUITextMapper.map(album.albumType),
                year = dateTime.formatter.format {
                    setInput(
                        DateTimeInput.FromString(
                            date = album.releaseDate,
                            format = DreamDateTimeFormat.YYYY_MM_DD
                        )
                    )
                    setOutputFormat(DreamDateTimeFormat.YYYY)
                }
            )
        }
    }

    private fun mapToArtists(state: AlbumDetailsState): Skeleton<ImmutableList<ArtistLabelUIData>> = with(state) {
        Skeleton.from(
            isLoading = artists.isEmpty()
        ) {
            artists.mapWith(artistDataToLabelUIDataMapper).toImmutableList()
        }
    }

    private fun mapToTracks(state: AlbumDetailsState): Skeleton<ImmutableList<TrackCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = album.tracks.isEmpty()
        ) {
            album.tracks.items
                .asSequence()
                .sortedBy { track -> track.trackNumber }
                .mapWith(trackInfoToTrackCardUIDataMapper)
                .toImmutableList()
        }
    }
}