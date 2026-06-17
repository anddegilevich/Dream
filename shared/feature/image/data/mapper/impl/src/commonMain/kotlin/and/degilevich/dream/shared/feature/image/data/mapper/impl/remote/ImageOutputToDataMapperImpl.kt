package and.degilevich.dream.shared.feature.image.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageData
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orZero

internal class ImageOutputToDataMapperImpl : ImageOutputToDataMapper {

    override fun map(item: ImageObject): ImageData = with(item) {
        ImageData(
            url = url,
            height = height.orZero(),
            width = width.orZero()
        )
    }
}