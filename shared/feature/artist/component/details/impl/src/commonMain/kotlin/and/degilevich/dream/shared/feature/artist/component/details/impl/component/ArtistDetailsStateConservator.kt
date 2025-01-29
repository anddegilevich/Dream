package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import kotlinx.serialization.KSerializer

internal class ArtistDetailsStateConservator(
    config: ScreenConfig.ArtistDetails
) : ComponentStateConservator<ArtistDetailsState> {
    override val key: String = ArtistDetailsState::class.className()
    override val initialState: ArtistDetailsState = ArtistDetailsState(config = config)
    override val serializer: KSerializer<ArtistDetailsState> = ArtistDetailsState.serializer()
}