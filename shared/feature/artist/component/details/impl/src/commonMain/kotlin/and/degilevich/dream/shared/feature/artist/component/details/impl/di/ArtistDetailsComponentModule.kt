package and.degilevich.dream.shared.feature.artist.component.details.impl.di

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.ArtistDetailsComponentImpl
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun artistDetailsComponentModule() = module {
    factory<ArtistDetailsComponent> { (componentContext: ComponentContext, navArgs: ArtistDetailsNavArgs) ->
        ArtistDetailsComponentImpl(componentContext = componentContext, navArgs = navArgs)
    }
}
