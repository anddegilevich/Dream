package and.degilevich.dream.shared.core.filepicker.impl.di

import and.degilevich.dream.shared.core.filepicker.impl.FilePickerManagerImpl
import and.degilevich.dream.shared.core.filepicker.impl.channel.request.FilePickerRequestChannelImpl
import and.degilevich.dream.shared.core.filepicker.impl.channel.result.FilePickerResultChannelImpl
import and.degilevich.dream.shared.core.filepicker.api.FilePickerManager
import and.degilevich.dream.shared.core.filepicker.api.channel.request.FilePickerRequestChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.request.FilePickerRequestReceiveChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.request.FilePickerRequestSendChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.result.FilePickerResultChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.result.FilePickerResultReceiveChannel
import and.degilevich.dream.shared.core.filepicker.api.channel.result.FilePickerResultSendChannel
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

fun filePickerModule() = module {
    singleOf(::FilePickerRequestChannelImpl) binds arrayOf(
        FilePickerRequestSendChannel::class,
        FilePickerRequestReceiveChannel::class,
        FilePickerRequestChannel::class
    )
    singleOf(::FilePickerResultChannelImpl) binds arrayOf(
        FilePickerResultSendChannel::class,
        FilePickerResultReceiveChannel::class,
        FilePickerResultChannel::class
    )
    singleOf(::FilePickerManagerImpl) bind FilePickerManager::class
}