package and.degilevich.dream.shared.feature.search.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.ui.test.mapper.FakeArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class AlbumInfoToSearchCardUIDataMapperImplTest {

    @Test
    fun `map - multiple images - iconUrl uses the first image`() {
        val mapper = createMapper()
        val album = simplifiedAlbumData(
            id = "album-1",
            images = listOf(
                imageData(url = "https://first.image"),
                imageData(url = "https://second.image")
            )
        )
        val result = mapper.map(album)
        with(result) {
            id shouldBe AlbumId(value = "album-1")
            name shouldBe "Album album-1"
            iconUrl shouldBe "https://first.image"
            artistName shouldBe "Artist One, Artist Two"
        }
    }

    @Test
    fun `map - no images - iconUrl is empty`() {
        val album = simplifiedAlbumData(id = "album-1")
        val result = createMapper().map(album)
        result.iconUrl shouldBe ""
    }

    private fun createMapper() = AlbumInfoToSearchCardUIDataMapperImpl(
        artistsInfoToStringMapper = FakeArtistsInfoToStringMapper(onMap = { "Artist One, Artist Two" })
    )
}
