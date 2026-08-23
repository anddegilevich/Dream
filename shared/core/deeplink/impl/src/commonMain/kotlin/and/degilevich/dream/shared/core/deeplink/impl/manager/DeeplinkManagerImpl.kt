package and.degilevich.dream.shared.core.deeplink.impl.manager

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.deeplink.api.manager.DeeplinkManager
import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthRedirectSendChannel

internal class DeeplinkManagerImpl(
    private val webAuthRedirectChannel: WebAuthRedirectSendChannel
) : DeeplinkManager {

    override fun handleDeeplink(url: String) {
        when {
            url.startsWith(SharedBuildConfig.REDIRECT_URI) -> webAuthRedirectChannel.trySend(url)
        }
    }
}
