package and.degilevcih.dream.shared.core.filepicker.impl.di

import and.degilevcih.dream.shared.core.filepicker.impl.FilePickerRequestChannelImpl
import and.degilevcih.dream.shared.core.filepicker.impl.FilePickerResultChannelImpl
import and.degilevich.dream.shared.core.filepicker.api.FilePickerRequestChannel
import and.degilevich.dream.shared.core.filepicker.api.FilePickerResultChannel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

fun filePickerModule() = module {
    singleOf<FilePickerResultChannel>(::FilePickerResultChannelImpl)
    singleOf<FilePickerRequestChannel>(::FilePickerRequestChannelImpl)
}