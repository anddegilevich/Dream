package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.design.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AlbumReleasesUIStateMapper : Mapper<AlbumReleasesState, AlbumReleasesUIState>, KoinComponent {

    private val albumInfoToCardUIDataMapper: AlbumInfoToCardUIDataMapper by inject()

    override fun map(item: AlbumReleasesState): AlbumReleasesUIState {
        return AlbumReleasesUIState(
            releases = mapToReleases(state = item)
        )
    }

    private fun mapToReleases(state: AlbumReleasesState): Skeleton<ImmutableList<AlbumCardUIData>> {
        return with(state) {
            if (releases.isEmpty()) {
                Skeleton.Loading
            } else {
                Skeleton.Value(
                    value = releases
                        .asSequence()
                        .sortedBy { album -> album.releaseDate }
                        .mapWith(albumInfoToCardUIDataMapper)
                        .toImmutableList()
                )
            }
        }
    }
}