package and.degilevich.dream.shared.feature.artist.component.details.impl.store

import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsSideEffect
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.shared.navigation.api.model.args.ArtistDetailsNavArgs
import and.degilevich.dream.shared.template.component.impl.BaseStoreComponent
import com.arkivanov.decompose.ComponentContext

internal class ArtistDetailsStoreComponent(
    componentContext: ComponentContext,
    navArgs: ArtistDetailsNavArgs
) : BaseStoreComponent<
    ArtistDetailsState,
    ArtistDetailsIntent,
    ArtistDetailsSideEffect
    >(
    componentContext = componentContext,
    storeFactory = ArtistDetailsStoreFactory(),
    stateConservator = ArtistDetailsStateConservator(
        navArgs = navArgs
    )
)