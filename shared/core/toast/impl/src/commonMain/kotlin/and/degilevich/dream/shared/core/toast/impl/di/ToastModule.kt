package and.degilevich.dream.shared.core.toast.impl.di

import and.degilevich.dream.shared.core.toast.api.channel.ToastChannel
import and.degilevich.dream.shared.core.toast.api.channel.ToastReceiveChannel
import and.degilevich.dream.shared.core.toast.api.channel.ToastSendChannel
import and.degilevich.dream.shared.core.toast.api.factory.ToastFactory
import and.degilevich.dream.shared.core.toast.api.controller.ToastController
import and.degilevich.dream.shared.core.toast.impl.channel.ToastChannelImpl
import and.degilevich.dream.shared.core.toast.impl.factory.ToastFactoryImpl
import and.degilevich.dream.shared.core.toast.impl.controller.ToastControllerImpl
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

fun toastModule() = module {
    singleOf(::ToastControllerImpl) bind ToastController::class
    singleOf(::ToastChannelImpl) binds arrayOf(
        ToastSendChannel::class,
        ToastReceiveChannel::class,
        ToastChannel::class
    )
    factoryOf(::ToastFactoryImpl) bind ToastFactory::class
}