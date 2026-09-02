package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class AlbumReleasesComponentFactoryImpl : AlbumReleasesComponentFactory {

    override fun create(componentContext: ComponentContext): AlbumReleasesComponent = AlbumReleasesComponentImpl(
        componentContext = componentContext
    )
}
