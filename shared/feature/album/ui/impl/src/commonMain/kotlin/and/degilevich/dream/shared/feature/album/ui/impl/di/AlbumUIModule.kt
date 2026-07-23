package and.degilevich.dream.shared.feature.album.ui.impl.di

import and.degilevich.dream.shared.feature.album.ui.api.mapper.AlbumInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.album.ui.api.mapper.AlbumTypeToUITextMapper
import and.degilevich.dream.shared.feature.album.ui.impl.mapper.AlbumInfoToCardUIDataMapperImpl
import and.degilevich.dream.shared.feature.album.ui.impl.mapper.AlbumTypeToUITextMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun albumUIModule() = module {
    factoryOf(::AlbumInfoToCardUIDataMapperImpl) bind AlbumInfoToCardUIDataMapper::class
    factoryOf(::AlbumTypeToUITextMapperImpl) bind AlbumTypeToUITextMapper::class
}