package and.degilevich.dream.shared.feature.artist.component.details.impl.component

import and.degilevich.dream.shared.resource.api.ResourceManager
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.feature.artist.component.details.impl.store.model.ArtistDetailsState
import and.degilevich.dream.Res
import and.degilevich.dream.shared.feature.artist.design.api.mapper.ArtistDataToCardUIDataMapper
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ArtistDetailsUIStateMapper : Mapper<ArtistDetailsState, ArtistDetailsUIState>, KoinComponent {

    private val artistDataToCardUIDataMapper: ArtistDataToCardUIDataMapper by inject()
    private val resourceManager: ResourceManager by inject()

    override fun map(item: ArtistDetailsState): ArtistDetailsUIState {
        return with(item) {
            ArtistDetailsUIState(
                artistIconUrl = artist.images.firstOrNull()?.url.orEmpty(),
                artistName = resourceManager.getString(Res.strings.mask_artist_name, artist.name),
                similarArtists = similarArtists
                    .map { artist ->
                        artistDataToCardUIDataMapper.map(
                            artist = artist,
                            isEnabled = !isLoading
                        )
                    }
                    .toImmutableList()
            )
        }
    }
}