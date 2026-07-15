package and.degilevich.dream.shared.di

import and.degilevich.dream.shared.core.crypto.impl.di.cryptoModule
import and.degilevich.dream.shared.core.datetime.impl.di.datetimeModule
import and.degilevich.dream.shared.core.db.impl.di.dbModule
import and.degilevich.dream.shared.core.network.impl.di.networkModule
import and.degilevich.dream.shared.core.service.impl.di.serviceModule
import and.degilevich.dream.shared.core.storage.impl.di.storageModule
import and.degilevich.dream.shared.core.toast.impl.di.toastModule
import org.koin.dsl.module

internal fun coreModule() = module {
    includes(storageModule())
    includes(cryptoModule())
    includes(networkModule())
    includes(serviceModule())
    includes(datetimeModule())
    includes(dbModule())
    includes(toastModule())
}