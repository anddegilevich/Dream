package and.degilevich.dream.shared.core.service.test.model

import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject

fun imageObject(
    url: String = "https://image.url",
    height: Int? = null,
    width: Int? = null
): ImageObject = ImageObject(
    url = url,
    height = height,
    width = width
)
