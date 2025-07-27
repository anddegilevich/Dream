package and.degilevich.dream.shared.feature.track.component.details.impl.store

import and.degilevich.dream.shared.feature.track.component.details.impl.store.model.TrackDetailsState
import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import kotlinx.serialization.KSerializer

internal class TrackDetailsStateConservator(
    navArgs: TrackDetailsNavArgs
) : StoreStateConservator<TrackDetailsState> {
    override val key: String = TrackDetailsState::class.className()
    override val initialState: TrackDetailsState = TrackDetailsState(
        navArgs = navArgs,
        isLoading = false,
        track = TrackData.empty()
    )
    override val serializer: KSerializer<TrackDetailsState> = TrackDetailsState.serializer()
}