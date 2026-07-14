package and.degilevich.dream.shared.feature.track.component.details.impl.di

import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponent
import and.degilevich.dream.shared.feature.track.component.details.impl.component.TrackDetailsComponentImpl
import and.degilevich.dream.shared.navigation.api.model.args.TrackDetailsNavArgs
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun trackDetailsComponentModule() = module {
    factory<TrackDetailsComponent> { (componentContext: ComponentContext, navArgs: TrackDetailsNavArgs) ->
        TrackDetailsComponentImpl(
            componentContext = componentContext,
            navArgs = navArgs
        )
    }
}
