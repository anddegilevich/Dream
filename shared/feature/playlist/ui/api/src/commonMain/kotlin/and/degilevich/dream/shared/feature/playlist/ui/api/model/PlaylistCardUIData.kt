package and.degilevich.dream.shared.feature.playlist.ui.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.foundation.abstraction.id.identifier
import androidx.compose.runtime.Immutable

@Immutable
data class PlaylistCardUIData(
    override val id: Identifier,
    val iconUrl: String,
    val name: String,
) : Identified {
    companion object : EmptyFactory<PlaylistCardUIData> {
        override fun empty(): PlaylistCardUIData {
            return PlaylistCardUIData(
                id = identifier(""),
                iconUrl = "",
                name = ""
            )
        }
    }
}
