package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.navigation.api.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.template.component.DreamStoreComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.store.StoreFactory

internal class ArtistDetailsStoreComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
    navArgs: ArtistDetailsNavArgs
) : DreamStoreComponent<
    ArtistDetailsState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect
    >(
    componentContext = componentContext,
    storeFactory = ArtistDetailsStoreFactory(storeFactory = storeFactory),
    stateConservator = ArtistDetailsStateConservator(
        navArgs = navArgs
    )
)