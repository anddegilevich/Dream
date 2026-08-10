package and.degilevich.dream.shared.feature.image.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.imageObject
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ImageOutputToDataMapperImplTest {

    @Test
    fun `map - known height and width - copies scalar fields unchanged`() {
        val input = imageObject(
            url = "https://image.url/cover.jpg",
            height = 640,
            width = 640
        )
        val result = ImageOutputToDataMapperImpl().map(input)
        with(result) {
            url shouldBe input.url
            height shouldBe 640
            width shouldBe 640
        }
    }

    @Test
    fun `map - null height and width - falls back to zero`() {
        val input = imageObject(
            height = null,
            width = null
        )
        val result = ImageOutputToDataMapperImpl().map(input)
        with(result) {
            height shouldBe 0
            width shouldBe 0
        }
    }
}
