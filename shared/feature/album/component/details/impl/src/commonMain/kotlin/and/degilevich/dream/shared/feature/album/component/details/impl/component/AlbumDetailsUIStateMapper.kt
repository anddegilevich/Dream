package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.core.datetime.api.DreamDateTimeFormat
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsLayoutUIData
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumTypeToUITextMapper
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToLabelUIDataMapper
import and.degilevich.dream.shared.feature.artist.design.api.model.ArtistLabelUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.foundation.datetime.api.DateTime
import and.degilevich.dream.shared.foundation.datetime.api.common.DateTimeInput
import and.degilevich.dream.shated.feature.track.design.api.mapper.TrackInfoToTrackCardUIDataMapper
import and.degilevich.dream.shated.feature.track.design.api.model.TrackCardUIData
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AlbumDetailsUIStateMapper : Mapper<AlbumDetailsState, AlbumDetailsUIState>, KoinComponent {

    private val artistDataToLabelUIDataMapper: ArtistDataToLabelUIDataMapper by inject()
    private val trackInfoToTrackCardUIDataMapper: TrackInfoToTrackCardUIDataMapper by inject()
    private val albumTypeToUITextMapper: AlbumTypeToUITextMapper by inject()
    private val dateTime: DateTime by inject()

    override fun map(item: AlbumDetailsState): AlbumDetailsUIState {
        return AlbumDetailsUIState(
            info = mapToInfo(state = item),
            artists = mapToArtists(state = item),
            tracks = mapToTracks(state = item)
        )
    }

    private fun mapToInfo(state: AlbumDetailsState): Skeleton<AlbumDetailsLayoutUIData> {
        return with(state) {
            if (album.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    value = AlbumDetailsLayoutUIData(
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
                )
            }
        }
    }

    private fun mapToArtists(state: AlbumDetailsState): Skeleton<ImmutableList<ArtistLabelUIData>> {
        return with(state) {
            if (artists.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    value = artists.mapWith(artistDataToLabelUIDataMapper).toImmutableList()
                )
            }
        }
    }

    private fun mapToTracks(state: AlbumDetailsState): Skeleton<ImmutableList<TrackCardUIData>> {
        return with(state) {
            if (album.tracks.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    value = album.tracks.items
                        .asSequence()
                        .sortedBy { track -> track.trackNumber }
                        .mapWith(trackInfoToTrackCardUIDataMapper)
                        .toImmutableList()
                )
            }
        }
    }
}