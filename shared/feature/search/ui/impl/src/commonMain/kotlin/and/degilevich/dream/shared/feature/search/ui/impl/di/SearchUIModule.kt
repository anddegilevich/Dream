package and.degilevich.dream.shared.feature.search.ui.impl.di

import and.degilevich.dream.shared.feature.search.ui.api.mapper.AlbumInfoToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.ArtistDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.api.mapper.TrackDataToSearchCardUIDataMapper
import and.degilevich.dream.shared.feature.search.ui.impl.mapper.AlbumInfoToSearchCardUIDataMapperImpl
import and.degilevich.dream.shared.feature.search.ui.impl.mapper.ArtistDataToSearchCardUIDataMapperImpl
import and.degilevich.dream.shared.feature.search.ui.impl.mapper.TrackDataToSearchCardUIDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchUIModule() = module {
    factoryOf(::AlbumInfoToSearchCardUIDataMapperImpl) bind AlbumInfoToSearchCardUIDataMapper::class
    factoryOf(::ArtistDataToSearchCardUIDataMapperImpl) bind ArtistDataToSearchCardUIDataMapper::class
    factoryOf(::TrackDataToSearchCardUIDataMapperImpl) bind TrackDataToSearchCardUIDataMapper::class
}