package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.feature.album.ui.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.ui.api.model.AlbumCardUIData
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistInfoLayoutUIData
import and.degilevich.dream.shared.feature.artist.component.details.impl.component.model.ArtistDetailsState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsUIStateMapper : Mapper<ArtistDetailsState, ArtistDetailsUIState>, KoinComponent {
    private val albumInfoToCardUIDataMapper: AlbumInfoToCardUIDataMapper by inject()

    override fun map(item: ArtistDetailsState): ArtistDetailsUIState = with(item) {
        ArtistDetailsUIState(
            info = mapToInfo(state = this),
            albums = mapToAlbums(state = this)
        )
    }

    private fun mapToInfo(state: ArtistDetailsState): Skeleton<ArtistInfoLayoutUIData> = with(state) {
        Skeleton.from(
            isLoading = artist.isEmpty()
        ) {
            ArtistInfoLayoutUIData(
                iconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                name = artist.name,
            )
        }
    }

    private fun mapToAlbums(state: ArtistDetailsState): Skeleton<ImmutableList<AlbumCardUIData>> = with(state) {
        Skeleton.from(
            isLoading = albums.isEmpty()
        ) {
            albums
                .asSequence()
                .sortedBy { album -> album.releaseDate }
                .mapWith(albumInfoToCardUIDataMapper)
                .toImmutableList()
        }
    }
}