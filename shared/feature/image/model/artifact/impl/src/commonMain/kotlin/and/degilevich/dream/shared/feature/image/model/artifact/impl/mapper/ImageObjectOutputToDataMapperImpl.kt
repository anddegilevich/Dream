package and.degilevich.dream.shared.feature.image.model.artifact.impl.mapper

import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageObjectData
import and.degilevich.dream.shared.feature.image.model.artifact.api.mapper.ImageObjectOutputToDataMapper

internal class ImageObjectOutputToDataMapperImpl : ImageObjectOutputToDataMapper {
    override fun map(item: ImageObjectOutput): ImageObjectData {
        return with(item) {
            ImageObjectData(
                url = url.orEmpty(),
                height = height.orEmpty(),
                width = width.orEmpty()
            )
        }
    }
}