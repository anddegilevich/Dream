package and.degilevich.dream.shared.feature.player.component.recentlyPlayed.api.component

import com.arkivanov.decompose.ComponentContext

interface RecentlyPlayedComponentFactory {

    fun create(componentContext: ComponentContext): RecentlyPlayedComponent
}
