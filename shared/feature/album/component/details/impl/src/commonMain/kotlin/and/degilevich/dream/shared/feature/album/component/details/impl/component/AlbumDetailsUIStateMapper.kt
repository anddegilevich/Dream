package and.degilevich.dream.shared.feature.album.component.details.impl.component

import and.degilevich.dream.shared.feature.album.component.details.api.component.model.AlbumDetailsUIState
import and.degilevich.dream.shared.feature.album.component.details.impl.store.model.AlbumDetailsState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class AlbumDetailsUIStateMapper : Mapper<AlbumDetailsState, AlbumDetailsUIState> {

    override fun map(item: AlbumDetailsState): AlbumDetailsUIState {
        return with(item) {
            AlbumDetailsUIState(
                name = album.name,
                iconUrl = album.images.firstOrNull()?.url.orEmpty()
            )
        }
    }
}