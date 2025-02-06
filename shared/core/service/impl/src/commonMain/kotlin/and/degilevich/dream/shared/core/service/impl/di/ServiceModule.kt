package and.degilevich.dream.shared.core.service.impl.di

import and.degilevich.dream.shared.core.service.api.Service
import and.degilevich.dream.shared.core.service.impl.ServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun serviceModule() = module {
    singleOf(::ServiceImpl) bind Service::class
}