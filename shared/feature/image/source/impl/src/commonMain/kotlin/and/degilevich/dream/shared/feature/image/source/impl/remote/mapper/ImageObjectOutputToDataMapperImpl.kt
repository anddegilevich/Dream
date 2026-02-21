package and.degilevich.dream.shared.feature.image.source.impl.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageObjectData
import and.degilevich.dream.shared.feature.image.source.api.remote.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class ImageObjectOutputToDataMapperImpl : ImageObjectOutputToDataMapper {

    override fun map(item: ImageObjectOutput): ImageObjectData {
        return with(item) {
            ImageObjectData(
                url = url.orEmpty(),
                height = height.orZero(),
                width = width.orZero()
            )
        }
    }
}