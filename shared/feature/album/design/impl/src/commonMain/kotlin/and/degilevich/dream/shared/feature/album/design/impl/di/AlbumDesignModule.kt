package and.degilevich.dream.shared.feature.album.design.impl.di

import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumDataToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.design.impl.mapper.AlbumDataToCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDesignModule() = module {
    factoryOf(::AlbumDataToCardUIDataMapperImpl) bind AlbumDataToCardUIDataMapper::class
}