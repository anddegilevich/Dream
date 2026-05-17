package and.degilevich.dream.shared.feature.image.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageObjectData
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class ImageObjectOutputToDataMapperImpl : ImageObjectOutputToDataMapper {

    override fun map(item: ImageObjectOutput): ImageObjectData = with(item) {
        ImageObjectData(
            url = url.orEmpty(),
            height = height.orZero(),
            width = width.orZero()
        )
    }
}