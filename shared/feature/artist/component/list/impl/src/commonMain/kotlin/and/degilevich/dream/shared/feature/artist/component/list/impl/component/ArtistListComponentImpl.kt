package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.common.component.view.StoreViewComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListMessage
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

class ArtistListComponentImpl(
    storeFactory: StoreFactory,
    componentContext: ComponentContext
) : StoreViewComponent<ArtistListUIState, ArtistListIntent, ArtistListSideEffect, ArtistListState, ArtistListMessage>(
    storeFactory = ArtistListStoreFactory(storeFactory = storeFactory),
    componentContext = componentContext,
    uiStateMapper = ArtistListUIStateMapper(),
    initialUIState = ArtistListUIState(),
    stateConservator = ArtistListStateConservator()
),
    ArtistListComponent