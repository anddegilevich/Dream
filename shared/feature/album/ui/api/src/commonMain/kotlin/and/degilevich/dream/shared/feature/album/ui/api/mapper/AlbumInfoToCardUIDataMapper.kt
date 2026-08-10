package and.degilevich.dream.shared.feature.album.ui.api.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.album.ui.api.model.AlbumCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumInfoToCardUIDataMapper : Mapper<AlbumInfo, AlbumCardUIData>