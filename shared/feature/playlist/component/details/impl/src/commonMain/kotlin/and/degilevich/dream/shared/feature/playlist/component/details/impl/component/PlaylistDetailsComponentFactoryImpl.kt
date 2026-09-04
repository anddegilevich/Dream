package and.degilevich.dream.shared.feature.playlist.component.details.impl.component

import and.degilevich.dream.shared.feature.playlist.component.details.api.component.PlaylistDetailsComponent
import and.degilevich.dream.shared.feature.playlist.component.details.api.component.PlaylistDetailsComponentFactory
import and.degilevich.dream.shared.navigation.api.model.args.PlaylistDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

internal class PlaylistDetailsComponentFactoryImpl : PlaylistDetailsComponentFactory {

    override fun create(
        componentContext: ComponentContext,
        navArgs: PlaylistDetailsNavArgs
    ): PlaylistDetailsComponent = PlaylistDetailsComponentImpl(
        componentContext = componentContext,
        navArgs = navArgs
    )
}
