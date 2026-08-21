package and.degilevich.dream.shared.feature.album.ui.impl.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumId
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.SimplifiedAlbumData
import and.degilevich.dream.shared.feature.artist.ui.test.mapper.FakeArtistsInfoToStringMapper
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class AlbumInfoToCardUIDataMapperImplTest {

    @Test
    fun `map - multiple images - iconUrl uses the first image`() {
        val mapper = createMapper()
        val album = SimplifiedAlbumData.empty().copy(
            id = AlbumId(value = "album-1"),
            name = "Album Name",
            images = listOf(
                imageData(url = "https://first.image"),
                imageData(url = "https://second.image")
            )
        )

        val result = mapper.map(album)
        with(result) {
            id shouldBe AlbumId(value = "album-1")
            name shouldBe "Album Name"
            iconUrl shouldBe "https://first.image"
            artists shouldBe "Artist One, Artist Two"
        }
    }

    @Test
    fun `map - no images - iconUrl is empty`() {
        val album = SimplifiedAlbumData.empty().copy(images = emptyList())
        val result = createMapper().map(album)
        result.iconUrl shouldBe ""
    }

    private fun createMapper() = AlbumInfoToCardUIDataMapperImpl(
        artistsInfoToStringMapper = FakeArtistsInfoToStringMapper(onMap = { "Artist One, Artist Two" })
    )
}
