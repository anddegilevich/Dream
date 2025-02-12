package and.degilevich.dream.shared.core.toast.impl.di

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.manager.ToastManager
import and.degilevich.dream.shared.core.toast.impl.channel.ToastChannelImpl
import and.degilevich.dream.shared.core.toast.impl.manager.ToastManagerImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

fun toastModule() = module {
    singleOf(::ToastManagerImpl) bind ToastManager::class
    singleOf(::ToastChannelImpl) bind ToastChannel::class
}