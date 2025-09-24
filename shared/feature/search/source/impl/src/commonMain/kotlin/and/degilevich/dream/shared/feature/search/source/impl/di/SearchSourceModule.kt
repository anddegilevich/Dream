package and.degilevich.dream.shared.feature.search.source.impl.di

import and.degilevich.dream.shared.feature.search.source.api.remote.SearchRemoteDataSource
import and.degilevich.dream.shared.feature.search.source.api.remote.mapper.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.source.api.remote.mapper.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.source.api.remote.mapper.SearchParamsToRequestMapper
import and.degilevich.dream.shared.feature.search.source.api.remote.mapper.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.source.api.remote.mapper.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.source.impl.remote.SearchRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchAlbumsOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchArtistsOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.search.source.impl.remote.mapper.SearchTracksOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchSourceModule() = module {
    singleOf(::SearchRemoteDataSourceImpl) bind SearchRemoteDataSource::class

    // Mapper
    factoryOf(::SearchParamsToRequestMapperImpl) bind SearchParamsToRequestMapper::class
    factoryOf(::SearchResponseToResultMapperImpl) bind SearchResponseToResultMapper::class
    factoryOf(::SearchAlbumsOutputToDataMapperImpl) bind SearchAlbumsOutputToDataMapper::class
    factoryOf(::SearchTracksOutputToDataMapperImpl) bind SearchTracksOutputToDataMapper::class
    factoryOf(::SearchArtistsOutputToDataMapperImpl) bind SearchArtistsOutputToDataMapper::class
}