package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.impl.store.AlbumDetailsStoreComponent
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.navigation.api.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.template.component.impl.UIStoreComponentTemplate
import com.arkivanov.decompose.ComponentContext

class AlbumDetailsComponentImpl(
    componentContext: ComponentContext,
    navArgs: AlbumDetailsNavArgs
) : UIStoreComponentTemplate<
    AlbumDetailsUIState,
    AlbumDetailsIntent,
    AlbumDetailsSideEffect,
    AlbumDetailsState,
    >(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        AlbumDetailsStoreComponent(
            componentContext = childComponentContext,
            navArgs = navArgs
        )
    },
    initialUIState = AlbumDetailsUIState.empty(),
    uiStateMapper = AlbumDetailsUIStateMapper()
),
    AlbumDetailsComponent