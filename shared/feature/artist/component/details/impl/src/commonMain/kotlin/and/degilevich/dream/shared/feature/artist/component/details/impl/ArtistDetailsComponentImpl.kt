package and.degilevich.dream.shared.feature.artist.component.details.impl

import and.degilevich.dream.shared.common.component.view.AbstractViewComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsUIState
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.navigation.api.dream.navigator.DreamNavigator
import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

//FIXME: Remove KoinComponent
class ArtistDetailsComponentImpl(
    componentContext: ComponentContext,
    config: ScreenConfig.ArtistDetails
) : AbstractViewComponent<ArtistDetailsUIState, ArtistDetailsIntent, Nothing>(
    componentContext = componentContext
),
    ArtistDetailsComponent,
    KoinComponent {

    init {
        //FIXME: remove
        println(config)
    }

    private val navigator: DreamNavigator by inject()

    override val state: StateFlow<ArtistDetailsUIState> = MutableStateFlow(ArtistDetailsUIState())
    override val sideEffect: Flow<Nothing> = flow { }

    override fun handleIntent(intent: ArtistDetailsIntent) {
        when (intent) {
            is ArtistDetailsIntent.OnBackCLicked -> {
                navigator.screenNavigator.pop()
            }

            is ArtistDetailsIntent.OnSimilarArtistClicked,
            is ArtistDetailsIntent.OnSubscribeClicked -> Unit
        }
    }
}