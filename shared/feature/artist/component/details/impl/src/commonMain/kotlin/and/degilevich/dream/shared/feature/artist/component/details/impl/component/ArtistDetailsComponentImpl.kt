package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.ArtistDetailsStoreFactory
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsMessage
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.decompose.component.view.StoreViewComponent
import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

class ArtistDetailsComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    config: ScreenConfig.ArtistDetails
) : StoreViewComponent<
    ArtistDetailsUIState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect,
    ArtistDetailsState,
    ArtistDetailsMessage
    >(
    storeFactory = ArtistDetailsStoreFactory(storeFactory = storeFactory),
    componentContext = componentContext,
    uiStateMapper = ArtistDetailsUIStateMapper(),
    initialUIState = ArtistDetailsUIState(),
    stateConservator = ArtistDetailsStateConservator(
        config = config
    )
),
    ArtistDetailsComponent