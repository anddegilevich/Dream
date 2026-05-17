package and.degilevich.dream.shared.feature.image.data.mapper.impl.di

import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.impl.remote.ImageObjectOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun imageDataMapperModule() = module {
    factoryOf(::ImageObjectOutputToDataMapperImpl) bind ImageObjectOutputToDataMapper::class
}
