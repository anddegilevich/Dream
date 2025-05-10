package and.degilevich.dream.shared.feature.album.model.artifact.api.mapper

import and.degilevich.dream.shared.core.service.api.core.album.AlbumTracksOutput
import and.degilevich.dream.shared.feature.album.model.artifact.api.data.AlbumTracksData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface AlbumTracksOutputToDataMapper : Mapper<AlbumTracksOutput, AlbumTracksData>