package and.degilevich.dream.shared.feature.search.data.mapper.impl.di

import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchAlbumsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchArtistsOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchParamsToRequestMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchResponseToResultMapper
import and.degilevich.dream.shared.feature.search.data.mapper.api.remote.SearchTracksOutputToDataMapper
import and.degilevich.dream.shared.feature.search.data.mapper.impl.remote.SearchAlbumsOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.search.data.mapper.impl.remote.SearchArtistsOutputToDataMapperImpl
import and.degilevich.dream.shared.feature.search.data.mapper.impl.remote.SearchParamsToRequestMapperImpl
import and.degilevich.dream.shared.feature.search.data.mapper.impl.remote.SearchResponseToResultMapperImpl
import and.degilevich.dream.shared.feature.search.data.mapper.impl.remote.SearchTracksOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun searchDataMapperModule() = module {
    factoryOf(::SearchParamsToRequestMapperImpl) bind SearchParamsToRequestMapper::class
    factoryOf(::SearchResponseToResultMapperImpl) bind SearchResponseToResultMapper::class
    factoryOf(::SearchAlbumsOutputToDataMapperImpl) bind SearchAlbumsOutputToDataMapper::class
    factoryOf(::SearchTracksOutputToDataMapperImpl) bind SearchTracksOutputToDataMapper::class
    factoryOf(::SearchArtistsOutputToDataMapperImpl) bind SearchArtistsOutputToDataMapper::class
}
