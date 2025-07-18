package and.degilevich.dream.shared.feature.album.component.details.impl.store

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.navigation.api.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.template.component.impl.BaseStoreComponent
import com.arkivanov.decompose.ComponentContext

internal class AlbumDetailsStoreComponent(
    componentContext: ComponentContext,
    navArgs: AlbumDetailsNavArgs
) : BaseStoreComponent<
    AlbumDetailsState,
    AlbumDetailsIntent,
    AlbumDetailsSideEffect
    >(
    componentContext = componentContext,
    storeFactory = AlbumDetailsStoreFactory(),
    stateConservator = AlbumDetailsStateConservator(
        navArgs = navArgs
    )
)