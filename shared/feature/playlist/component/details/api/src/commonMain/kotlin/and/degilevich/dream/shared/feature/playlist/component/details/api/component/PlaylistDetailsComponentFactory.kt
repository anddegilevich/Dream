package and.degilevich.dream.shared.feature.playlist.component.details.api.component

import and.degilevich.dream.shared.navigation.api.model.args.PlaylistDetailsNavArgs
import com.arkivanov.decompose.ComponentContext

interface PlaylistDetailsComponentFactory {

    fun create(
        componentContext: ComponentContext,
        navArgs: PlaylistDetailsNavArgs
    ): PlaylistDetailsComponent
}
