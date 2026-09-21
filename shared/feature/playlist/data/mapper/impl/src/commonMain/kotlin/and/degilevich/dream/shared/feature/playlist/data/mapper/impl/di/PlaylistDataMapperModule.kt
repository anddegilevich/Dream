package and.degilevich.dream.shared.feature.playlist.data.mapper.impl.di

import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.PlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.local.SimplifiedPlaylistDataToEntityMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTrackOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.PlaylistTracksResponseToResultMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.api.remote.SimplifiedPlaylistOutputToDataMapper
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.local.PlaylistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.local.SimplifiedPlaylistDataToEntityMapperImpl
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote.PlaylistOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote.PlaylistTrackOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote.PlaylistTracksResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.playlist.data.mapper.impl.remote.SimplifiedPlaylistOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun playlistDataMapperModule() = module {
    factoryOf(::SimplifiedPlaylistDataToEntityMapperImpl) bind SimplifiedPlaylistDataToEntityMapper::class
    factoryOf(::PlaylistDataToEntityMapperImpl) bind PlaylistDataToEntityMapper::class
    factoryOf(::SimplifiedPlaylistOutputToDataMapperImpl) bind SimplifiedPlaylistOutputToDataMapper::class
    factoryOf(::PlaylistOutputToDataMapperImpl) bind PlaylistOutputToDataMapper::class
    factoryOf(::PlaylistTrackOutputToDataMapperImpl) bind PlaylistTrackOutputToDataMapper::class
    factoryOf(::PlaylistTracksResponseToResultMapperImpl) bind PlaylistTracksResponseToResultMapper::class
}
