package and.degilevich.dream.shared.feature.album.data.api.remote.mapper

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumOutput
import and.degilevich.dream.shared.feature.album.model.core.data.AlbumData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumOutputToDataMapper : Mapper<AlbumOutput, AlbumData>