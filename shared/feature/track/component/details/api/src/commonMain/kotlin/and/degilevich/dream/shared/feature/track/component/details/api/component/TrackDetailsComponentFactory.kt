package and.degilevich.dream.shared.feature.track.component.details.api.component

import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

interface TrackDetailsComponentFactory {

    fun create(
        componentContext: ComponentContext,
        navArgs: TrackDetailsNavArgs
    ): TrackDetailsComponent
}
