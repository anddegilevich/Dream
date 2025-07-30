package and.degilevich.dream.shared.feature.album.model.core.api.mapper

import and.degilevich.dream.shared.core.service.api.model.method.getNewReleases.NewReleasesAlbumsOutput
import and.degilevich.dream.shared.feature.album.model.core.api.data.NewReleasesAlbumsData
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

interface NewReleasesAlbumsOutputToDataMapper : Mapper<NewReleasesAlbumsOutput, NewReleasesAlbumsData>