package and.degilevich.dream.shared.feature.album.design.impl.di

import and.degilevich.dream.shared.feature.album.design.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.design.impl.mapper.AlbumInfoToCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumDesignModule() = module {
    factoryOf(::AlbumInfoToCardUIDataMapperImpl) bind AlbumInfoToCardUIDataMapper::class
}