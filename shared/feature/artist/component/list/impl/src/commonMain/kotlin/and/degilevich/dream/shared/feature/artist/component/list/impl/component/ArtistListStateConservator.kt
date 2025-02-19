package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.ComponentStateConservator
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class ArtistListStateConservator : ComponentStateConservator<ArtistListState> {
    override val key: String = ArtistListState::class.className()
    override val initialState: ArtistListState = ArtistListState()
    override val serializer: KSerializer<ArtistListState> = ArtistListState.serializer()
}