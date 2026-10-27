package and.degilevich.dream.shared.feature.user.domain.model.core.test.data

import and.degilevich.dream.shared.feature.image.domain.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.user.domain.model.artifact.api.data.UserId
import and.degilevich.dream.shared.feature.user.domain.model.core.api.data.UserData

fun userData(
    id: String,
    displayName: String = "User $id",
    images: List<ImageData> = emptyList()
): UserData = UserData(
    id = UserId(value = id),
    displayName = displayName,
    images = images
)
