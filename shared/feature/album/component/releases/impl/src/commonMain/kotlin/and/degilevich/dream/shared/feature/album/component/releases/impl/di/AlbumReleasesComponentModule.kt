package and.degilevich.dream.shared.feature.album.component.releases.impl.di

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.AlbumReleasesComponentImpl
import com.arkivanov.decompose.ComponentContext
import org.koin.dsl.module

fun albumReleasesComponentModule() = module {
    factory<AlbumReleasesComponent> { (componentContext: ComponentContext) ->
        AlbumReleasesComponentImpl(componentContext = componentContext)
    }
}
