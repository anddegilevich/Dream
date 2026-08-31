package and.degilevich.dream.shared.core.webauth.impl.di

import org.koin.dsl.module

fun webAuthModule() = module {
    includes(webAuthPlatformModule())
}
