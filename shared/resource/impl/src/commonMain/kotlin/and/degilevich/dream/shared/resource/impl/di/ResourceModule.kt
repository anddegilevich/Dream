package and.degilevich.dream.shared.resource.impl.di

import org.koin.dsl.module

fun resourceModule() = module {
    includes(resourcePlatformModule())
}