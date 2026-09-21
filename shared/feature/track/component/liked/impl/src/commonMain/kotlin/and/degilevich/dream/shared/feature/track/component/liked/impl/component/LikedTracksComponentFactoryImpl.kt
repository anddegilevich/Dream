package and.degilevich.dream.shared.feature.track.component.liked.impl.component

import and.degilevich.dream.shared.feature.track.component.liked.api.component.LikedTracksComponent
import and.degilevich.dream.shared.feature.track.component.liked.api.component.LikedTracksComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class LikedTracksComponentFactoryImpl : LikedTracksComponentFactory {

    override fun create(componentContext: ComponentContext): LikedTracksComponent = LikedTracksComponentImpl(
        componentContext = componentContext
    )
}
