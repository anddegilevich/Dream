package and.degilevich.dream.shared.feature.album.data.mapper.api.remote

import and.degilevich.dream.shared.core.service.api.generated.model.SimplifiedAlbumObject
import and.degilevich.dream.shared.feature.album.model.artifact.data.SimplifiedAlbumData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface SimplifiedAlbumOutputToDataMapper : Mapper<SimplifiedAlbumObject, SimplifiedAlbumData>