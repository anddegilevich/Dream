package and.degilevich.dream.shared.feature.playlist.ui.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.emptyIdentifier
import and.degilevich.dream.shated.feature.track.ui.api.model.TrackCardInfoUIData
import androidx.compose.runtime.Immutable

@Immutable
data class PlaylistTrackCardUIData(
    override val id: Identifier,
    val number: String,
    val info: TrackCardInfoUIData,
    val albumCoverUrl: String
) : Identified {

    companion object : EmptyFactory<PlaylistTrackCardUIData> {

        override fun empty(): PlaylistTrackCardUIData {
            return PlaylistTrackCardUIData(
                id = emptyIdentifier(),
                number = "",
                info = TrackCardInfoUIData.empty(),
                albumCoverUrl = ""
            )
        }
    }
}
