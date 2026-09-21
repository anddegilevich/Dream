package and.degilevich.dream.shared.feature.player.model.core.api.data

import and.degilevich.dream.shared.feature.track.model.artifact.api.data.TrackId
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class PlayHistoryData(
    val track: TrackData,
    val playedAt: String
) : AbstractIdentified() {

    override val id: TrackId
        get() = track.id

    companion object : EmptyFactory<PlayHistoryData> {

        override fun empty(): PlayHistoryData {
            return PlayHistoryData(
                track = TrackData.empty(),
                playedAt = ""
            )
        }
    }
}
