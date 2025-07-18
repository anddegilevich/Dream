package and.degilevich.dream.shared.feature.album.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.album.AlbumOutput
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumOutputToDataMapper : Mapper<AlbumOutput, AlbumData>