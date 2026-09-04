package and.degilevich.dream.shared.feature.artist.component.details.api.component

import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

interface ArtistDetailsComponentFactory {

    fun create(
        componentContext: ComponentContext,
        navArgs: ArtistDetailsNavArgs
    ): ArtistDetailsComponent
}
