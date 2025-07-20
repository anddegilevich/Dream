package and.degilevich.dream.shared.feature.album.component.details.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDetailsUIState(
    val name: String,
    val iconUrl: String
) {
    companion object : EmptyFactory<AlbumDetailsUIState> {
        override fun empty(): AlbumDetailsUIState {
            return AlbumDetailsUIState(
                name = "",
                iconUrl = ""
            )
        }
    }
}