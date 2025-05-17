package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.AlbumReleasesComponent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.AlbumReleasesStoreComponent
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import and.degilevich.dream.shared.template.component.impl.UIStoreComponentTemplate
import com.arkivanov.decompose.ComponentContext

class AlbumReleasesComponentImpl(
    componentContext: ComponentContext
) : UIStoreComponentTemplate<
    AlbumReleasesUIState,
    AlbumReleasesIntent,
    AlbumReleasesSideEffect,
    AlbumReleasesState,
    >(
    componentContext = componentContext,
    storeComponentFactory = { childComponentContext ->
        AlbumReleasesStoreComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = AlbumReleasesUIState.empty(),
    uiStateMapper = AlbumReleasesUIStateMapper()
),
    AlbumReleasesComponent