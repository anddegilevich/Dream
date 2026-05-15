package and.degilevich.dream.shated.feature.track.ui.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.emptyIdentifier
import androidx.compose.runtime.Immutable

@Immutable
data class TrackCardUIData(
    override val id: Identifier,
    val number: String,
    val name: String,
    val artists: String
) : Identified {

    companion object : EmptyFactory<TrackCardUIData> {

        override fun empty(): TrackCardUIData {
            return TrackCardUIData(
                id = emptyIdentifier(),
                number = "",
                name = "",
                artists = ""
            )
        }
    }
}