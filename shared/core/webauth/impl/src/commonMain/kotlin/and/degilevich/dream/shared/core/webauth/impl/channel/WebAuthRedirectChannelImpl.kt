package and.degilevich.dream.shared.core.webauth.impl.channel

import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthRedirectChannel
import kotlinx.coroutines.channels.Channel

internal class WebAuthRedirectChannelImpl :
    WebAuthRedirectChannel,
    Channel<String> by Channel(capacity = Channel.CONFLATED)
