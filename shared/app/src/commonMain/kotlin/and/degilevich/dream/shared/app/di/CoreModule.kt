package and.degilevich.dream.shared.app.di

import and.degilevich.dream.shared.core.client.impl.di.clientModule
import org.koin.dsl.module

internal fun coreModule() = module {
    includes(clientModule())
}