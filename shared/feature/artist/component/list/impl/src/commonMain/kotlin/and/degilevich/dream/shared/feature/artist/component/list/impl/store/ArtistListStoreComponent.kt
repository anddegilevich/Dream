package and.degilevich.dream.shared.feature.artist.component.list.impl.store

import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListIntent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.model.ArtistListSideEffect
import and.degilevich.dream.shared.feature.artist.component.list.impl.store.model.ArtistListState
import and.degilevich.dream.shared.template.component.impl.StoreComponentTemplate
import com.arkivanov.decompose.ComponentContext

internal class ArtistListStoreComponent(
    componentContext: ComponentContext
) : StoreComponentTemplate<
    ArtistListState,
    ArtistListIntent,
    ArtistListSideEffect
    >(
    componentContext = componentContext,
    storeFactory = ArtistListStoreFactory(),
    stateConservator = ArtistListStateConservator()
)