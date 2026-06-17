package and.degilevich.dream.shared.feature.image.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.ImageObject
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ImageOutputToDataMapper : Mapper<ImageObject, ImageData>