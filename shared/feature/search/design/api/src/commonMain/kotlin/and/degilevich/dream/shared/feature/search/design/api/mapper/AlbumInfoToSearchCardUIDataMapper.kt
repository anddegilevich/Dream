package and.degilevich.dream.shared.feature.search.design.api.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.api.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.search.design.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumInfoToSearchCardUIDataMapper : Mapper<AlbumInfo, AlbumSearchCardUIData>