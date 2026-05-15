package and.degilevich.dream.shared.feature.image.data.impl.di

import and.degilevich.dream.shared.feature.image.data.api.remote.mapper.ImageObjectOutputToDataMapper
import and.degilevich.dream.shared.feature.image.data.impl.remote.mapper.ImageObjectOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun imageDataModule() = module {
    factoryOf(::ImageObjectOutputToDataMapperImpl) bind ImageObjectOutputToDataMapper::class
}