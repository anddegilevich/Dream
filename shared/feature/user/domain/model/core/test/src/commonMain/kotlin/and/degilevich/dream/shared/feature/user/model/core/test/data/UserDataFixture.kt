package and.degilevich.dream.shared.feature.user.model.core.test.data

import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.user.model.artifact.api.data.UserId
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData

fun userData(
    id: String,
    displayName: String = "User $id",
    images: List<ImageData> = emptyList()
): UserData = UserData(
    id = UserId(value = id),
    displayName = displayName,
    images = images
)
