package and.degilevich.dream.shared.app.impl.di

import and.degilevich.dream.shared.core.client.impl.di.clientModule
import and.degilevich.dream.shared.core.storage.impl.di.storageModule
import org.koin.dsl.module

internal fun coreModule() = module {
    includes(clientModule())
    includes(storageModule())
}