package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.ArtistDetailsStoreComponent
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.template.component.DreamUIStoreComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

class ArtistDetailsComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    navArgs: ArtistDetailsNavArgs
) : DreamUIStoreComponent<
    ArtistDetailsUIState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect,
    ArtistDetailsState,
    >(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        ArtistDetailsStoreComponent(
            componentContext = childComponentContext,
            storeFactory = storeFactory,
            navArgs = navArgs
        )
    },
    initialUIState = ArtistDetailsUIState(),
    uiStateMapper = ArtistDetailsUIStateMapper()
),
    ArtistDetailsComponent