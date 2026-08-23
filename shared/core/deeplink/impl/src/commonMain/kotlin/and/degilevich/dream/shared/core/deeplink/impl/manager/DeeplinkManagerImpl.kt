package and.degilevich.dream.shared.core.deeplink.impl.manager

import and.degilevich.dream.shared.core.deeplink.api.manager.DeeplinkManager
import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthRedirectSendChannel

internal class DeeplinkManagerImpl(
    private val webAuthRedirectChannel: WebAuthRedirectSendChannel
) : DeeplinkManager {

    override fun handleDeeplink(url: String) {
        when {
            url.startsWith(WEB_AUTH_REDIRECT_PREFIX) -> webAuthRedirectChannel.trySend(url)
        }
    }

    private companion object {
        const val WEB_AUTH_REDIRECT_PREFIX = "dream://auth"
    }
}
