package and.degilevich.dream.shared.feature.image.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.model.data.image.ImageObjectOutput
import and.degilevich.dream.shared.feature.image.model.artifact.data.ImageObjectData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface ImageObjectOutputToDataMapper : Mapper<ImageObjectOutput, ImageObjectData>