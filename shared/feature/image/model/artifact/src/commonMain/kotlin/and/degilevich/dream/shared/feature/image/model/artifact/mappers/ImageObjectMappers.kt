package and.degilevich.dream.shared.feature.image.model.artifact.mappers

import and.degilevich.dream.shared.core.service.api.core.image.ImageObjectOutput
import and.degilevich.dream.shared.feature.image.model.artifact.ImageObjectData
import and.degilevich.dream.shared.foundation.model.empty.state.ext.orEmpty

fun ImageObjectOutput?.mapToDomain(): ImageObjectData {
    return this?.let {
        ImageObjectData.Base(
            url = url.orEmpty(),
            height = height.orEmpty(),
            width = width.orEmpty()
        )
    }.orEmpty(ImageObjectData)
}