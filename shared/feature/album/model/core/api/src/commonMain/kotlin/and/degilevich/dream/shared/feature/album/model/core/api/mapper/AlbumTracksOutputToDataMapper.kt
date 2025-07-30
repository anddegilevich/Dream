package and.degilevich.dream.shared.feature.album.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.data.album.AlbumTracksOutput
import and.degilevich.dream.shared.feature.album.model.core.api.data.AlbumTracksData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumTracksOutputToDataMapper : Mapper<AlbumTracksOutput, AlbumTracksData>