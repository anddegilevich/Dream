package and.degilevich.dream.shated.feature.track.design.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import androidx.compose.runtime.Immutable

@Immutable
data class TrackCardUIData(
    override val id: String,
    val number: String,
    val name: String,
    val artists: String
) : Identified {
    companion object : EmptyFactory<TrackCardUIData> {
        override fun empty(): TrackCardUIData {
            return TrackCardUIData(
                id = "",
                number = "",
                name = "",
                artists = ""
            )
        }
    }
}