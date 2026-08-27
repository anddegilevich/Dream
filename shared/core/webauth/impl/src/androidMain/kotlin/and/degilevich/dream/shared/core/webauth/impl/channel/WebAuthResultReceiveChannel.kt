package and.degilevich.dream.shared.core.webauth.impl.channel

import and.degilevich.dream.shared.core.webauth.impl.model.WebAuthResult
import kotlinx.coroutines.channels.ReceiveChannel

internal interface WebAuthResultReceiveChannel : ReceiveChannel<WebAuthResult>
