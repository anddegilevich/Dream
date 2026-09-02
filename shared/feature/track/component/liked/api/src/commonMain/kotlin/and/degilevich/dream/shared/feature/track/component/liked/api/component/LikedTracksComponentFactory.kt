package and.degilevich.dream.shared.feature.track.component.liked.api.component

import com.arkivanov.decompose.ComponentContext

interface LikedTracksComponentFactory {

    fun create(componentContext: ComponentContext): LikedTracksComponent
}
