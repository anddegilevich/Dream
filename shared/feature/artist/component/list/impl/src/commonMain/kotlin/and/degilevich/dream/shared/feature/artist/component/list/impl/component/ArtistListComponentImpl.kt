package and.degilevich.dream.shared.feature.artist.component.list.impl.component

import and.degilevich.dream.shared.template.component.DreamSingleStoreComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListUIState
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.ArtistListStoreComponent
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

class ArtistListComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : DreamSingleStoreComponent<
    ArtistListUIState,
    ArtistListIntent,
    ArtistListSideEffect,
    ArtistListState,
    >(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        ArtistListStoreComponent(
            componentContext = childComponentContext,
            storeFactory = storeFactory
        )
    },
    initialUIState = ArtistListUIState(),
    uiStateMapper = ArtistListUIStateMapper()
),
    ArtistListComponent