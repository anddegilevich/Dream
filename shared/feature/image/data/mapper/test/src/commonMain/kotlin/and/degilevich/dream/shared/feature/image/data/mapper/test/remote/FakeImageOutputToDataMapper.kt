package and.degilevich.dream.shared.feature.image.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeImageOutputToDataMapper(
    private val onMap: (ImageObject) -> ImageData = { fakeImplementationError() }
) : ImageOutputToDataMapper {

    override fun map(item: ImageObject): ImageData = onMap(item)
}
