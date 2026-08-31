package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.di

import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.SimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.local.SimplifiedPlaylistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote.SimplifiedPlaylistOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistDataMapperModule() = module {
    factoryOf(::SimplifiedPlaylistDataToEntityMapperImpl) bind SimplifiedPlaylistDataToEntityMapper::class
    factoryOf(::SimplifiedPlaylistOutputToDataMapperImpl) bind SimplifiedPlaylistOutputToDataMapper::class
}
