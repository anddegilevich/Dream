package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class ArtistListStateConservator : StoreStateConservator<ArtistListState> {
    override val key: String = ArtistListState::class.className()
    override val initialState: ArtistListState = ArtistListState(
        isLoading = true,
        artists = emptyList()
    )
    override val serializer: KSerializer<ArtistListState> = ArtistListState.serializer()
}