package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListMessage
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import com.arkivanov.mvikotlin.core.store.Reducer

internal class ArtistListReducer : Reducer<ArtistListState, ArtistListMessage> {
    override fun ArtistListState.reduce(msg: ArtistListMessage): ArtistListState {
        return when (msg) {
            is ArtistListMessage.SetArtists -> copy(
                artists = msg.artists
            )

            is ArtistListMessage.SetLoading -> copy(
                isLoading = msg.isLoading
            )
        }
    }
}