package and.degilevich.dream.shared.core.client.impl.di

import org.koin.dsl.module

fun clientModule() = module {
    includes(clientPlatformModule())
}