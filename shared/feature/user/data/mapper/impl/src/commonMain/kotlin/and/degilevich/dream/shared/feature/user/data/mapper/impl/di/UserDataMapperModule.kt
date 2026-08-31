package and.degilevich.dream.shared.feature.user.data.mapper.impl.di

import and.degilevich.dream.shared.feature.user.data.mapper.api.remote.UserOutputToDataMapper
import and.degilevich.dream.shared.feature.user.data.mapper.impl.remote.UserOutputToDataMapperImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun userDataMapperModule() = module {
    factoryOf(::UserOutputToDataMapperImpl) bind UserOutputToDataMapper::class
}
