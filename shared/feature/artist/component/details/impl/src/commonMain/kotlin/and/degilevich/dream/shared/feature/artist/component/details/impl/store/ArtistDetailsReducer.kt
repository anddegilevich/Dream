package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsMessage
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import com.arkivanov.mvikotlin.core.store.Reducer

internal class ArtistDetailsReducer : Reducer<ArtistDetailsState, ArtistDetailsMessage> {
    override fun ArtistDetailsState.reduce(msg: ArtistDetailsMessage): ArtistDetailsState {
        return when (msg) {
            is ArtistDetailsMessage.SetArtist -> copy(
                artist = msg.artist
            )

            is ArtistDetailsMessage.SetLoading -> copy(
                isLoading = msg.isLoading
            )
        }
    }
}