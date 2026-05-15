package and.degilevich.dream.shared.feature.album.data.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumSimplifiedOutput
import and.degilevich.dream.shared.feature.album.model.artifact.data.AlbumSimplifiedData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumSimplifiedOutputToDataMapper : Mapper<AlbumSimplifiedOutput, AlbumSimplifiedData>