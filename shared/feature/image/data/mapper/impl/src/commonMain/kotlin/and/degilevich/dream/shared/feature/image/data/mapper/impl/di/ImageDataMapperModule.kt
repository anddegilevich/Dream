package and.degilevich.dream.shared.feature.image.data.mapper.impl.di

import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.mapper.impl.remote.ImageOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun imageDataMapperModule() = module {
    factoryOf(::ImageOutputToDataMapperImpl) bind ImageOutputToDataMapper::class
}
