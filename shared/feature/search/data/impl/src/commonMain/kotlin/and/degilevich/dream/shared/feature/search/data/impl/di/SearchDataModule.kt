package and.degilevich.dream.shared.feature.search.data.impl.di

import and.degilevich.dream.shared.feature.search.data.api.remote.SearchRemoteDataSource
import and.degilevich.dream.shared.feature.search.data.api.remote.mapper.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.api.remote.mapper.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.api.remote.mapper.SearchParamsToRequestMapper
import and.degilevich.dream.shared.feature.search.data.api.remote.mapper.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.data.api.remote.mapper.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.impl.remote.SearchRemoteDataSourceImpl
import and.degilevich.dream.shared.feature.search.data.impl.remote.mapper.SearchAlbumsOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.search.data.impl.remote.mapper.SearchArtistsOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.search.data.impl.remote.mapper.SearchParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.search.data.impl.remote.mapper.SearchResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.search.data.impl.remote.mapper.SearchTracksOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchDataModule() = module {
    singleOf(::SearchRemoteDataSourceImpl) bind SearchRemoteDataSource::class

    // Mapper
    factoryOf(::SearchParamsToRequestMapperImpl) bind SearchParamsToRequestMapper::class
    factoryOf(::SearchResponseToResultMapperImpl) bind SearchResponseToResultMapper::class
    factoryOf(::SearchAlbumsOutputToDataMapperImpl) bind SearchAlbumsOutputToDataMapper::class
    factoryOf(::SearchTracksOutputToDataMapperImpl) bind SearchTracksOutputToDataMapper::class
    factoryOf(::SearchArtistsOutputToDataMapperImpl) bind SearchArtistsOutputToDataMapper::class
}