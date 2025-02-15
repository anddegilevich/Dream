package and.degilevich.dream.shared.feature.image.model.artifact.mappers

import and.degilevich.dream.shared.core.service.api.core.image.ImageObjectOutput
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageObjectData
import and.degilevich.dream.shared.foundation.model.empty.state.ext.orEmpty

fun ImageObjectOutput?.mapToData(): ImageObjectData {
    return this?.let {
        ImageObjectData(
            url = url.orEmpty(),
            height = height.orEmpty(),
            width = width.orEmpty()
        )
    }.orEmpty(ImageObjectData)
}