package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import kotlinx.serialization.KSerializer

internal class ArtistDetailsStateConservator(
    config: ScreenConfig.ArtistDetails
) : ComponentStateConservator<ArtistDetailsState> {
    override val key: String = ArtistDetailsState::class.className()
    override val initialState: ArtistDetailsState = ArtistDetailsState(
        navArgs = config.navArgs
    )
    override val serializer: KSerializer<ArtistDetailsState> = ArtistDetailsState.serializer()
}