package and.degilevich.dream.shared.feature.playlist.component.list.impl.component

import and.degilevich.dream.shared.feature.playlist.component.list.api.component.PlaylistListComponent
import and.degilevich.dream.shared.feature.playlist.component.list.api.component.PlaylistListComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class PlaylistListComponentFactoryImpl : PlaylistListComponentFactory {

    override fun create(componentContext: ComponentContext): PlaylistListComponent = PlaylistListComponentImpl(
        componentContext = componentContext
    )
}
