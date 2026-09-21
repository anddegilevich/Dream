package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.impl.component

import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.api.component.RecentlyPlayedComponent
import and.degilevich.dream.shared.feature.player.component.recentlyPlayed.api.component.RecentlyPlayedComponentFactory
import com.arkivanov.decompose.ComponentContext

internal class RecentlyPlayedComponentFactoryImpl : RecentlyPlayedComponentFactory {

    override fun create(componentContext: ComponentContext): RecentlyPlayedComponent = RecentlyPlayedComponentImpl(
        componentContext = componentContext
    )
}
