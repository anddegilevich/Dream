package and.degilevich.dream.shared.feature.image.domain.model.artifact.test.data

import and.degilevich.dream.shared.feature.image.domain.model.artifact.api.data.ImageData

fun imageData(
    url: String = "https://image.url",
    height: Int = 100,
    width: Int = 100
): ImageData = ImageData(
    url = url,
    height = height,
    width = width
)
