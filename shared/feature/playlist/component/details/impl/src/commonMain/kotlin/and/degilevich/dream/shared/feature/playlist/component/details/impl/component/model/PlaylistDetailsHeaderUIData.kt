package and.degilevich.dream.shared.feature.playlist.component.details.impl.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
data class PlaylistDetailsHeaderUIData(
    val coverUrl: String,
    val name: String,
    val description: String,
    val isVisibleDescription: Boolean
) {

    companion object : EmptyFactory<PlaylistDetailsHeaderUIData> {

        override fun empty(): PlaylistDetailsHeaderUIData {
            return PlaylistDetailsHeaderUIData(
                coverUrl = "",
                name = "",
                description = "",
                isVisibleDescription = false
            )
        }
    }
}
