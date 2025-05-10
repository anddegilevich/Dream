package and.degilevich.dream.shared.feature.track.model.artifact.impl.di

import and.degilevich.dream.shared.feature.track.model.artifact.api.mapper.TrackSimplifiedOutputToDataMapper
import and.degilevich.dream.shared.feature.track.model.artifact.impl.mapper.TrackSimplifiedOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun trackModelArtifactModule() = module {
    factoryOf(::TrackSimplifiedOutputToDataMapperImpl) bind TrackSimplifiedOutputToDataMapper::class
}