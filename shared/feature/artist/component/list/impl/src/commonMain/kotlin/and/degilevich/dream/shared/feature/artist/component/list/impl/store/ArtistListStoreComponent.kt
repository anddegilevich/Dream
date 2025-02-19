package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.component.ArtistListStateConservator
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.template.component.DreamStoreComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ArtistListStoreComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : DreamStoreComponent<
    ArtistListState,
    ArtistListIntent,
    ArtistListSideEffect
    >(
    componentContext = componentContext,
    storeFactory = ArtistListStoreFactory(storeFactory = storeFactory),
    stateConservator = ArtistListStateConservator()
)