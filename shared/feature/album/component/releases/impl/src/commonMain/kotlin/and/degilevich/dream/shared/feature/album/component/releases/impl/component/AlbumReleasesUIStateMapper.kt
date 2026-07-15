package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesState
import and.degilevich.dream.shared.feature.album.component.releases.impl.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.ui.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.ui.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AlbumReleasesUIStateMapper : Mapper<AlbumReleasesState, AlbumReleasesUIState>, KoinComponent {

    private val albumInfoToCardUIDataMapper: AlbumInfoToCardUIDataMapper by inject()

    override fun map(item: AlbumReleasesState): AlbumReleasesUIState = with(item) {
        AlbumReleasesUIState(
            releases = mapToReleases(state = this)
        )
    }

    private fun mapToReleases(state: AlbumReleasesState): Skeleton<ImmutableList<AlbumCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = releases.isEmpty()
        ) {
            releases
                .asSequence()
                .sortedBy { album -> album.releaseDate }
                .mapWith(albumInfoToCardUIDataMapper)
                .toImmutableList()
        }
    }
}