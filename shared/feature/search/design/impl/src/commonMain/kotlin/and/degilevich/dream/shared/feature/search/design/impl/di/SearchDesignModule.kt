package and.degilevich.dream.shared.feature.search.design.impl.di

import and.degilevich.dream.shared.feature.search.design.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.mapper.ArtistDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.api.mapper.TrackDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.design.impl.mapper.AlbumInfoToSearchCardUIDataMapperImpl
import and.degilevich.dream.shared.feature.search.design.impl.mapper.ArtistDataToSearchCardUIDataMapperImpl
import and.degilevich.dream.shared.feature.search.design.impl.mapper.TrackDataToSearchCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchDesignModule() = module {
    factoryOf(::AlbumInfoToSearchCardUIDataMapperImpl) bind AlbumInfoToSearchCardUIDataMapper::class
    factoryOf(::ArtistDataToSearchCardUIDataMapperImpl) bind ArtistDataToSearchCardUIDataMapper::class
    factoryOf(::TrackDataToSearchCardUIDataMapperImpl) bind TrackDataToSearchCardUIDataMapper::class
}