package and.degilevich.dream.shared.core.webauth.impl.di

import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthResultChannel
import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthResultReceiveChannel
import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthResultSendChannel
import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthResultChannelImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.binds
import org.koin.dsl.module

fun webAuthModule() = module {
    singleOf(::WebAuthResultChannelImpl) binds arrayOf(
        WebAuthResultSendChannel::class,
        WebAuthResultReceiveChannel::class,
        WebAuthResultChannel::class
    )
    includes(webAuthPlatformModule())
}
