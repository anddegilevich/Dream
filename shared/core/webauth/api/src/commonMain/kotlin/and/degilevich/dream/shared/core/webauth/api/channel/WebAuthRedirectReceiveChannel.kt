package and.degilevich.dream.shared.core.webauth.api.channel

import kotlinx.coroutines.channels.ReceiveChannel

interface WebAuthRedirectReceiveChannel : ReceiveChannel<String>
