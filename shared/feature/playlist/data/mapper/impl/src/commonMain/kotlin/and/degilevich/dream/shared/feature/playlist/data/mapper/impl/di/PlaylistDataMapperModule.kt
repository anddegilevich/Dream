package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.di

import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote.SimplifiedPlaylistOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistDataMapperModule() = module {
    factoryOf(::SimplifiedPlaylistOutputToDataMapperImpl) bind SimplifiedPlaylistOutputToDataMapper::class
}
