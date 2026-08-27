package and.degilevich.dream.shared.core.webauth.api.channel

import and.degilevich.dream.shared.core.webauth.api.model.WebAuthResult
import kotlinx.coroutines.channels.ReceiveChannel

interface WebAuthResultReceiveChannel : ReceiveChannel<WebAuthResult>
