package and.degilevich.dream.shared.feature.album.data.mapper.impl.local

import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.artifact.test.data.simplifiedAlbumData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class SimplifiedAlbumDataToEntityMapperImplTest {

    @Test
    fun `map - simplified album data - copies all scalar fields to entity`() {
        val mapper = createMapper()
        val album = simplifiedAlbumData(
            id = "album-2",
            artists = emptyList(),
            albumType = AlbumType.COMPILATION,
            totalTracks = 5,
            releaseDate = "2019-06-15"
        )
        val entity = mapper.map(album)
        with(entity) {
            id shouldBe "album-2"
            name shouldBe "Album album-2"
            albumType shouldBe "compilation"
            totalTracks shouldBe 5
            releaseDate shouldBe "2019-06-15"
        }
    }

    private fun createMapper() = SimplifiedAlbumDataToEntityMapperImpl()
}
