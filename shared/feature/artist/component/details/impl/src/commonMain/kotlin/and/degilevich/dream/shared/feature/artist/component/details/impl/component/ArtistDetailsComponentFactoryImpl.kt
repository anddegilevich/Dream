package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponentFactory
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

internal class ArtistDetailsComponentFactoryImpl : ArtistDetailsComponentFactory {

    override fun create(
        componentContext: ComponentContext,
        navArgs: ArtistDetailsNavArgs
    ): ArtistDetailsComponent = ArtistDetailsComponentImpl(
        componentContext = componentContext,
        navArgs = navArgs
    )
}
