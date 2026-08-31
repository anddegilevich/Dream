package and.degilevich.dream.shared.core.webauth.impl.channel

import and.degilevich.dream.shared.core.webauth.impl.model.WebAuthResult
import kotlinx.coroutines.channels.Channel

internal class WebAuthResultChannelImpl :
    WebAuthResultChannel,
    Channel<WebAuthResult> by Channel(capacity = Channel.BUFFERED)