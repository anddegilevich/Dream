package and.degilevich.dream.shared.feature.track.component.details.impl.store.model

import and.degilevich.dream.shared.feature.track.model.core.api.data.TrackData
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import kotlinx.serialization.Serializable

@Serializable
data class TrackDetailsState(
    val navArgs: TrackDetailsNavArgs,
    val isLoading: Boolean,
    val track: TrackData
)