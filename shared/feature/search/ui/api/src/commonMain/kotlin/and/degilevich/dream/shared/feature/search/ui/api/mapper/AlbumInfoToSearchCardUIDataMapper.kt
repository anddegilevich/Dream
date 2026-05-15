package and.degilevich.dream.shared.feature.search.ui.api.mapper

import and.degilevich.dream.shared.feature.album.model.artifact.abstraction.AlbumInfo
import and.degilevich.dream.shared.feature.search.ui.api.model.card.AlbumSearchCardUIData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumInfoToSearchCardUIDataMapper : Mapper<AlbumInfo, AlbumSearchCardUIData>