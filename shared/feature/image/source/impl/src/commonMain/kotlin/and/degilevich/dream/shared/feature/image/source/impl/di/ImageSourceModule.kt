package and.degilevich.dream.shared.feature.image.source.impl.di

import and.degilevich.dream.shared.feature.image.source.api.remote.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.feature.image.source.impl.remote.mapper.ImageObjectOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun imageSourceModule() = module {
    factoryOf(::ImageObjectOutputToDataMapperImpl) bind ImageObjectOutputToDataMapper::class
}