package and.degilevich.dream.shared.feature.image.model.artifact.impl.di

import and.degilevich.dream.shared.feature.image.model.artifact.api.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.feature.image.model.artifact.impl.mapper.ImageObjectOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun imageModelArtifactModule() = module {
    factoryOf(::ImageObjectOutputToDataMapperImpl) bind ImageObjectOutputToDataMapper::class
}