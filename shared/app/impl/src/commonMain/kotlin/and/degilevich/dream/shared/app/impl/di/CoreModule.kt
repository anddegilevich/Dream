package and.degilevich.dream.shared.app.impl.di

import and.degilevcih.dream.shared.core.filepicker.impl.di.filePickerModule
import and.degilevich.dream.shared.core.client.impl.di.clientModule
import and.degilevich.dream.shared.core.db.impl.di.dbModule
import and.degilevich.dream.shared.core.service.impl.di.serviceModule
import and.degilevich.dream.shared.core.storage.impl.di.storageModule
import and.degilevich.dream.shared.core.toast.impl.di.toastModule
import org.koin.dsl.module

internal fun coreModule() = module {
    includes(storageModule())
    includes(clientModule())
    includes(serviceModule())
    includes(dbModule())
    includes(toastModule())
    includes(filePickerModule())
}