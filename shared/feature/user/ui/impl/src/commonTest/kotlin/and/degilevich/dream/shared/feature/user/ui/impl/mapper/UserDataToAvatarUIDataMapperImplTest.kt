package and.degilevich.dream.shared.feature.user.ui.impl.mapper

import and.degilevich.dream.shared.feature.image.model.artifact.test.data.imageData
import and.degilevich.dream.shared.feature.user.model.core.test.data.userData
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class UserDataToAvatarUIDataMapperImplTest {

    @Test
    fun `map - multiple images - url uses the first image`() {
        val user = userData(
            id = "user-1",
            images = listOf(
                imageData(url = "https://first.image"),
                imageData(url = "https://second.image")
            )
        )
        val result = UserDataToAvatarUIDataMapperImpl().map(user)
        result.url shouldBe "https://first.image"
    }

    @Test
    fun `map - no images - url is empty`() {
        val user = userData(
            id = "user-1",
            images = emptyList()
        )
        val result = UserDataToAvatarUIDataMapperImpl().map(user)
        result.url shouldBe ""
    }

    @Test
    fun `map - lowercase display name - firstLetter is the uppercased first character`() {
        val user = userData(
            id = "user-1",
            displayName = "andrey"
        )
        val result = UserDataToAvatarUIDataMapperImpl().map(user)
        result.firstLetter shouldBe "A"
    }

    @Test
    fun `map - display name with leading spaces - firstLetter skips the whitespace`() {
        val user = userData(
            id = "user-1",
            displayName = "  bob"
        )
        val result = UserDataToAvatarUIDataMapperImpl().map(user)
        result.firstLetter shouldBe "B"
    }
}
