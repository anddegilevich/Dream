package and.degilevich.dream.shared.core.webauth.impl.channel

import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthResultChannel
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthResult
import kotlinx.coroutines.channels.Channel

internal class WebAuthResultChannelImpl :
    WebAuthResultChannel,
    Channel<WebAuthResult> by Channel(capacity = Channel.BUFFERED)