package and.degilevich.dream.shared.core.webauth.api.channel

import kotlinx.coroutines.channels.SendChannel

interface WebAuthRedirectSendChannel : SendChannel<String>
