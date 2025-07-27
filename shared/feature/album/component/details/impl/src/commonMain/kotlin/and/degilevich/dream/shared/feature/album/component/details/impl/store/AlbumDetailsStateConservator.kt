package and.degilevich.dream.shared.feature.album.component.details.impl.store

import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import kotlinx.serialization.KSerializer

internal class AlbumDetailsStateConservator(
    navArgs: AlbumDetailsNavArgs
) : StoreStateConservator<AlbumDetailsState> {
    override val key: String = AlbumDetailsState::class.className()
    override val initialState: AlbumDetailsState = AlbumDetailsState(
        navArgs = navArgs,
        isLoading = true,
        album = AlbumData.empty(),
        artists = emptyList()
    )
    override val serializer: KSerializer<AlbumDetailsState> = AlbumDetailsState.serializer()
}