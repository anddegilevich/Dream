package and.degilevich.dream.shared.core.webauth.impl.di

import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthRedirectChannel
import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthRedirectReceiveChannel
import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthRedirectSendChannel
import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthRedirectChannelImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.binds
import org.koin.dsl.module

fun webAuthModule() = module {
    singleOf(::WebAuthRedirectChannelImpl) binds arrayOf(
        WebAuthRedirectSendChannel::class,
        WebAuthRedirectReceiveChannel::class,
        WebAuthRedirectChannel::class
    )
    includes(webAuthPlatformModule())
}
