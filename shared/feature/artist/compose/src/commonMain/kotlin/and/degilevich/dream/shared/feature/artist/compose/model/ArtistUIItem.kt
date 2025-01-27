package and.degilevich.dream.shared.feature.artist.compose.model

import and.degilevich.dream.shared.foundation.model.id.Identified
import androidx.compose.runtime.Stable

@Stable
data class ArtistUIItem(
    override val id: String = "",
    val name: String = "",
    val iconUrl: String = ""
) : Identified
