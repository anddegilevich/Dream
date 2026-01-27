package and.degilevich.dream.shared.core.crypto.impl.di

import org.koin.dsl.module

fun cryptoModule() = module {
    includes(cryptoPlatformModule())
}