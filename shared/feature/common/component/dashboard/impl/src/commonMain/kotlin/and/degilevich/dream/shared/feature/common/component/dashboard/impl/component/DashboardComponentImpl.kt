package and.degilevich.dream.shared.feature.common.component.dashboard.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.AlbumReleasesComponentImpl
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardIntent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardSideEffect
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardUIState
import and.degilevich.dream.shared.template.component.impl.BaseMVIComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.childContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DashboardComponentImpl(
    componentContext: ComponentContext
) : BaseMVIComponent<DashboardUIState, DashboardIntent, DashboardSideEffect>(
    componentContext = componentContext
),
    DashboardComponent {

    private val coroutineScope = coroutineScope()

    private val albumReleasesComponent: AlbumReleasesComponent = AlbumReleasesComponentImpl(
        componentContext = childContext(
            key = ALBUM_RELEASES_KEY
        )
    )

    override val state: StateFlow<DashboardUIState> = albumReleasesComponent.state
        .map { albumReleasesState ->
            DashboardUIState(
                albumReleasesCarousel = albumReleasesState
            )
        }
        .flowOn(context = Dispatchers.Default)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = DashboardUIState.empty()
        )
    override val sideEffect: Flow<DashboardSideEffect> = emptyFlow()

    override fun handleIntent(intent: DashboardIntent) {
        when (intent) {
            is DashboardIntent.OnAlbumReleasesIntent -> albumReleasesComponent.handleIntent(intent.intent)
        }
    }

    private companion object {
        const val ALBUM_RELEASES_KEY = "albumReleases"
    }
}