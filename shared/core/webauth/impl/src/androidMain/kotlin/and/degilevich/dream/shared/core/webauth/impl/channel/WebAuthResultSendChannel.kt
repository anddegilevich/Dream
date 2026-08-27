package and.degilevich.dream.shared.core.webauth.impl.channel

import and.degilevich.dream.shared.core.webauth.impl.model.WebAuthResult
import kotlinx.coroutines.channels.SendChannel

internal interface WebAuthResultSendChannel : SendChannel<WebAuthResult>
