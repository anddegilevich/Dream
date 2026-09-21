package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.model.core.test.data.artistData
import and.degilevich.dream.shared.feature.search.model.core.api.data.SearchItemData
import and.degilevich.dream.shared.feature.search.ui.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.ArtistDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.TrackDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.ArtistSearchCardUIData
import and.degilevich.dream.shared.feature.search.ui.api.model.card.TrackSearchCardUIData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SearchItemDataToSearchCardUIDataMapperImplTest {

    @Test
    fun `map - artist item - delegates to the artist card mapper`() {
        val artist = artistData(id = "artist-1")
        val card = ArtistSearchCardUIData.empty().copy(name = "Artist")
        val mapper = createMapper(
            artistDataToSearchCardUIDataMapper = FakeArtistDataToSearchCardUIDataMapper(onMap = { card })
        )

        val result = mapper.map(SearchItemData.Artist(artist = artist))

        result shouldBe card
    }

    @Test
    fun `map - album item - delegates to the album card mapper`() {
        val album = simplifiedAlbumData(id = "album-1")
        val card = AlbumSearchCardUIData.empty().copy(name = "Album")
        val mapper = createMapper(
            albumInfoToSearchCardUIDataMapper = FakeAlbumInfoToSearchCardUIDataMapper(onMap = { card })
        )

        val result = mapper.map(SearchItemData.Album(album = album))

        result shouldBe card
    }

    @Test
    fun `map - track item - delegates to the track card mapper`() {
        val track = trackData(id = "track-1")
        val card = TrackSearchCardUIData.empty().copy(name = "Track")
        val mapper = createMapper(
            trackDataToSearchCardUIDataMapper = FakeTrackDataToSearchCardUIDataMapper(onMap = { card })
        )

        val result = mapper.map(SearchItemData.Track(track = track))

        result shouldBe card
    }

    private fun createMapper(
        artistDataToSearchCardUIDataMapper: ArtistDataToSearchCardUIDataMapper =
            FakeArtistDataToSearchCardUIDataMapper(),
        albumInfoToSearchCardUIDataMapper: AlbumInfoToSearchCardUIDataMapper =
            FakeAlbumInfoToSearchCardUIDataMapper(),
        trackDataToSearchCardUIDataMapper: TrackDataToSearchCardUIDataMapper =
            FakeTrackDataToSearchCardUIDataMapper()
    ) = SearchItemDataToSearchCardUIDataMapperImpl(
        artistDataToSearchCardUIDataMapper = artistDataToSearchCardUIDataMapper,
        albumInfoToSearchCardUIDataMapper = albumInfoToSearchCardUIDataMapper,
        trackDataToSearchCardUIDataMapper = trackDataToSearchCardUIDataMapper
    )
}
