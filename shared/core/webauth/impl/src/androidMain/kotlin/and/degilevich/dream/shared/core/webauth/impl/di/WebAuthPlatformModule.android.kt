package and.degilevich.dream.shared.core.webauth.impl.di

import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthResultChannel
import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthResultReceiveChannel
import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthResultSendChannel
import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthResultChannelImpl
import and.degilevich.dream.shared.core.webauth.impl.launcher.WebAuthLauncherImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.binds
import org.koin.dsl.module

internal actual fun webAuthPlatformModule() = module {
    singleOf(::WebAuthResultChannelImpl) binds arrayOf(
        WebAuthResultSendChannel::class,
        WebAuthResultReceiveChannel::class,
        WebAuthResultChannel::class
    )
    singleOf(::WebAuthLauncherImpl) bind WebAuthLauncher::class
}
