package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.common.component.view.AbstractViewComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.ArtistListExecutor
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.ArtistListReducer
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.states
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import org.koin.core.component.KoinComponent

//FIXME: Remove KoinComponent
class ArtistListComponentImpl(
    storeFactory: StoreFactory,
    componentContext: ComponentContext
) : AbstractViewComponent<ArtistListUIState, ArtistListIntent, Nothing>(
    componentContext = componentContext
),
    ArtistListComponent,
    KoinComponent {

    private val store: Store<ArtistListIntent, ArtistListState, Nothing> = instanceKeeper.getStore {
        storeFactory.create(
            initialState = ArtistListState(),
            executorFactory = {
                ArtistListExecutor(
                    lifecycle = lifecycle
                )
            },
            reducer = ArtistListReducer()
        )
    }

    private val uiStateMapper = ArtistListUIStateMapper()

    override val state: StateFlow<ArtistListUIState> = store.states
        .map(uiStateMapper::map)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.Lazily,
            initialValue = ArtistListUIState()
        )

    override val sideEffect: Flow<Nothing> = store.labels

    override fun handleIntent(intent: ArtistListIntent) {
        store.accept(intent)
    }
}