package and.degilevich.dream.shared.feature.playlist.component.list.api.component

import com.arkivanov.decompose.ComponentContext

interface PlaylistListComponentFactory {

    fun create(componentContext: ComponentContext): PlaylistListComponent
}
