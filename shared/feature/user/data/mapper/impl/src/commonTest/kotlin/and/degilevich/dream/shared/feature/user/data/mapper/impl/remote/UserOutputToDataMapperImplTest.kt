package and.degilevich.dream.shared.feature.user.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.test.model.imageObject
import and.degilevich.dream.shared.core.service.test.model.privateUserObject
import and.degilevich.dream.shared.feature.image.data.mapper.test.remote.FakeImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class UserOutputToDataMapperImplTest {

    @Test
    fun `map - populated object - copies scalars and delegates images to injected mapper`() {
        val imageData = imageData()
        val mapper = UserOutputToDataMapperImpl(
            imageOutputToDataMapper = FakeImageOutputToDataMapper(onMap = { imageData })
        )
        val input = privateUserObject(
            images = listOf(
                imageObject(),
                imageObject()
            )
        )
        val result = mapper.map(input)
        with(result) {
            id.value shouldBe input.id
            displayName shouldBe input.displayName
            images shouldBe listOf(imageData, imageData)
        }
    }

    @Test
    fun `map - null id, display name and images - falls back to empty values`() {
        val mapper = UserOutputToDataMapperImpl(
            imageOutputToDataMapper = FakeImageOutputToDataMapper()
        )
        val input = privateUserObject(
            id = null,
            displayName = null,
            images = null
        )
        val result = mapper.map(input)
        with(result) {
            id.value shouldBe ""
            displayName shouldBe ""
            images shouldBe emptyList()
        }
    }
}
