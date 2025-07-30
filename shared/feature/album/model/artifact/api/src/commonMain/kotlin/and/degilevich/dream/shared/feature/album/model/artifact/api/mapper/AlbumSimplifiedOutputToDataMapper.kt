package and.degilevich.dream.shared.feature.album.model.artifact.api.mapper

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumSimplifiedOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumSimplifiedOutputToDataMapper : Mapper<AlbumSimplifiedOutput, AlbumSimplifiedData>