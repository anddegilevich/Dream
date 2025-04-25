package and.degilevich.dream.shared.feature.artist.design.api.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import androidx.compose.runtime.Immutable

@Immutable
data class ArtistCardUIState(
    override val id: String = "",
    val name: String = "",
    val iconUrl: String = "",
    val isEnabled: Boolean = true
) : Identified
