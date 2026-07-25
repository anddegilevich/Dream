package and.degilevich.dream.shared.feature.album.data.mapper.impl.local

import and.degilevich.dream.shared.feature.album.model.artifact.api.dictionary.AlbumType
import and.degilevich.dream.shared.feature.album.model.core.test.data.albumData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class AlbumDataToEntityMapperImplTest {

    @Test
    fun `map - full album data - copies all scalar fields to entity`() {
        val mapper = createMapper()
        val album = albumData(id = "album-1", albumType = AlbumType.SINGLE, totalTracks = 12)
        val entity = mapper.map(album)
        with(entity) {
            id shouldBe "album-1"
            name shouldBe "Album album-1"
            albumType shouldBe "single"
            totalTracks shouldBe 12
            releaseDate shouldBe "2021-01-01"
        }
    }

    private fun createMapper() = AlbumDataToEntityMapperImpl()
}
