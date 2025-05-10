package and.degilevich.dream.shared.feature.album.model.artifact.api.mapper

import and.degilevich.dream.shared.core.service.api.core.album.AlbumOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumOutputToDataMapper : Mapper<AlbumOutput, AlbumData>