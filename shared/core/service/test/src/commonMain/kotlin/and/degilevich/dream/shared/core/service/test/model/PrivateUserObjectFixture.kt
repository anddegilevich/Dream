package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.core.service.api.generated.model.PrivateUserObject

fun privateUserObject(
    id: String? = "user-id",
    displayName: String? = "User Name",
    images: List<ImageObject>? = emptyList()
): PrivateUserObject = PrivateUserObject(
    displayName = displayName,
    href = "https://api.spotify.com/v1/users/user-id",
    id = id,
    images = images,
    type = "user",
    uri = "spotify:user:user-id"
)
