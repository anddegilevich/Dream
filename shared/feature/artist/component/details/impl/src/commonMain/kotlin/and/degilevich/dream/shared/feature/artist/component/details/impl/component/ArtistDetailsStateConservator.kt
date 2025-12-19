package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsState
import and.degilevich.dream.shared.feature.artist.model.core.api.data.ArtistData
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import kotlinx.serialization.KSerializer

internal class ArtistDetailsStateConservator(
    navArgs: ArtistDetailsNavArgs
) : ComponentStateConservator<ArtistDetailsState> {
    override val key: String = ArtistDetailsState::class.className()
    override val initialState: ArtistDetailsState = ArtistDetailsState(
        navArgs = navArgs,
        isLoading = true,
        artist = ArtistData.empty(),
        topTracks = emptyList(),
        albums = emptyList()
    )
    override val serializer: KSerializer<ArtistDetailsState> = ArtistDetailsState.serializer()
}