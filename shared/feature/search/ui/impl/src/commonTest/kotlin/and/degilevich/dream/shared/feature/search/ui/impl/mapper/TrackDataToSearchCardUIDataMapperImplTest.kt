package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.ui.api.mapper.ArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.artist.ui.test.mapper.FakeArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import and.degilevich.dream.shared.feature.track.model.core.test.data.trackData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class TrackDataToSearchCardUIDataMapperImplTest {

    @Test
    fun `map - album with images - iconUrl uses the first image and delegates artist string`() {
        val album = SimplifiedAlbumData.empty().copy(
            images = listOf(
                imageData(url = "https://first.image"),
                imageData(url = "https://second.image")
            )
        )
        val track = trackData(
            id = "track-1",
            album = album
        )
        val mapper = createMapper(
            artistsInfoToStringMapper = FakeArtistsInfoToStringMapper(onMap = { "Artist One, Artist Two" })
        )
        val result = mapper.map(track)
        with(result) {
            id shouldBe track.id
            name shouldBe track.name
            iconUrl shouldBe "https://first.image"
            artistName shouldBe "Artist One, Artist Two"
        }
    }

    @Test
    fun `map - album with no images - iconUrl is empty`() {
        val track = trackData(
            id = "track-1",
            album = simplifiedAlbumData(
                id = "album-1",
                images = emptyList()
            )
        )
        val mapper = createMapper(
            artistsInfoToStringMapper = FakeArtistsInfoToStringMapper(onMap = { "" })
        )
        val result = mapper.map(track)
        result.iconUrl shouldBe ""
    }

    private fun createMapper(
        artistsInfoToStringMapper: ArtistsInfoToStringMapper = FakeArtistsInfoToStringMapper()
    ) = TrackDataToSearchCardUIDataMapperImpl(
        artistsInfoToStringMapper = artistsInfoToStringMapper
    )
}
