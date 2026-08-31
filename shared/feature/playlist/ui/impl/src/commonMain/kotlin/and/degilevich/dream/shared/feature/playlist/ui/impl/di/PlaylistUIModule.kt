package and.degilevich.dream.shared.feature.playlist.ui.impl.di

import and.degilevich.dream.shared.feature.playlist.ui.api.mapper.PlaylistInfoToCardUIDataMapper
import and.degilevich.dream.shared.feature.playlist.ui.impl.mapper.PlaylistInfoToCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistUIModule() = module {
    factoryOf(::PlaylistInfoToCardUIDataMapperImpl) bind PlaylistInfoToCardUIDataMapper::class
}
