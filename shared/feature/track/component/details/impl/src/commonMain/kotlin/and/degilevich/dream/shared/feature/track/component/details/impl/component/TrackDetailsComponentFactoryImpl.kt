package and.degilevich.dream.shared.feature.track.component.details.impl.component

import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponent
import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponentFactory
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

internal class TrackDetailsComponentFactoryImpl : TrackDetailsComponentFactory {

    override fun create(
        componentContext: ComponentContext,
        navArgs: TrackDetailsNavArgs
    ): TrackDetailsComponent = TrackDetailsComponentImpl(
        componentContext = componentContext,
        navArgs = navArgs
    )
}
