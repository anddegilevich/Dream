package and.degilevich.dream.shared.feature.image.model.artifact.api.mapper

import and.degilevich.dream.shared.core.service.api.core.image.ImageObjectOutput
import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageObjectData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ImageObjectOutputToDataMapper : Mapper<ImageObjectOutput, ImageObjectData>