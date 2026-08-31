package and.degilevich.dream.shared.feature.playlist.component.list.impl.di

import and.degilevich.dream.shared.feature.playlist.component.list.api.component.PlaylistListComponent
import and.degilevich.dream.shared.feature.playlist.component.list.impl.component.PlaylistListComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun playlistListComponentModule() = module {
    factory<PlaylistListComponent> { (componentContext: ComponentContext) ->
        PlaylistListComponentImpl(componentContext = componentContext)
    }
}
