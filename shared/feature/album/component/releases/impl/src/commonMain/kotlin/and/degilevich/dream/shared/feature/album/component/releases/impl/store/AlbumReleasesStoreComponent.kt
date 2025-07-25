package and.degilevich.dream.shared.feature.album.component.releases.impl.store

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesIntent
import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesSideEffect
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import and.degilevich.dream.shared.template.component.impl.BaseStoreComponent
import com.arkivanov.decompose.ComponentContext

internal class AlbumReleasesStoreComponent(
    componentContext: ComponentContext
) : BaseStoreComponent<
    AlbumReleasesState,
    AlbumReleasesIntent,
    AlbumReleasesSideEffect
    >(
    componentContext = componentContext,
    storeFactory = AlbumReleasesStoreFactory(),
    stateConservator = AlbumReleasesStateConservator()
)