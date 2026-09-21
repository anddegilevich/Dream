package and.degilevich.dream.shared.feature.album.component.releases.api.component

import com.arkivanov.decompose.ComponentContext

interface AlbumReleasesComponentFactory {

    fun create(componentContext: ComponentContext): AlbumReleasesComponent
}
