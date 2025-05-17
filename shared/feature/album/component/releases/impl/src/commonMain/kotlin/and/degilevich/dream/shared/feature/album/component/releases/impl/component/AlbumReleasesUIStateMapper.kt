package and.degilevich.dream.shared.feature.album.component.releases.impl.component

import and.degilevich.dream.shared.feature.album.component.releases.api.component.model.AlbumReleasesUIState
import and.degilevich.dream.shared.feature.album.component.releases.impl.store.model.AlbumReleasesState
import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import kotlinx.collections.immutable.toPersistentList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class AlbumReleasesUIStateMapper : Mapper<AlbumReleasesState, AlbumReleasesUIState>, KoinComponent {

    private val albumInfoToCardUIDataMapper: AlbumInfoToCardUIDataMapper by inject()

    override fun map(item: AlbumReleasesState): AlbumReleasesUIState {
        return with(item) {
            AlbumReleasesUIState(
                releases = releases.map { release ->
                    albumInfoToCardUIDataMapper.map(
                        album = release,
                        isEnabled = !isLoading
                    )
                }.toPersistentList()
            )
        }
    }
}