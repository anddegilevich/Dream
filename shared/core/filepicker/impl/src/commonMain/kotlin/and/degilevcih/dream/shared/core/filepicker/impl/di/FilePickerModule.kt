package and.degilevcih.dream.shared.core.filepicker.impl.di

import and.degilevcih.dream.shared.core.filepicker.impl.FilePickerManagerImpl
import and.degilevcih.dream.shared.core.filepicker.impl.FilePickerRequestChannelImpl
import and.degilevcih.dream.shared.core.filepicker.impl.FilePickerResultChannelImpl
import and.degilevich.dream.shared.core.filepicker.api.FilePickerManager
import and.degilevich.dream.shared.core.filepicker.api.FilePickerRequestChannel
import and.degilevich.dream.shared.core.filepicker.api.FilePickerResultChannel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun filePickerModule() = module {
    singleOf(::FilePickerResultChannelImpl) bind FilePickerResultChannel::class
    singleOf(::FilePickerRequestChannelImpl) bind FilePickerRequestChannel::class
    singleOf(::FilePickerManagerImpl) bind FilePickerManager::class
}