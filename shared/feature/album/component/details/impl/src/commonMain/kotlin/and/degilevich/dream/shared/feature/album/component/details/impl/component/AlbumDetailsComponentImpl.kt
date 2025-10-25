package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsIntent
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsSideEffect
import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.impl.component.model.AlbumDetailsState
import and.degilevich.dream.shared.navigation.api.model.args.AlbumDetailsNavArgs
import and.degilevich.dream.shared.template.component.impl.BaseBinderComponent
import com.arkivanov.decompose.ComponentContext

class AlbumDetailsComponentImpl(
    componentContext: ComponentContext,
    navArgs: AlbumDetailsNavArgs
) : BaseBinderComponent<
    AlbumDetailsUIState,
    AlbumDetailsIntent,
    AlbumDetailsSideEffect,
    AlbumDetailsState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        AlbumDetailsDomainComponent(
            componentContext = childComponentContext,
            navArgs = navArgs
        )
    },
    initialUIState = AlbumDetailsUIState.empty(),
    uiStateMapper = AlbumDetailsUIStateMapper()
),
    AlbumDetailsComponent