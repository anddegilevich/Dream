package and.degilevich.dream.shared.core.service.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class SessionData(
    val tokens: TokensData
) : EmptyState {

    override fun isEmpty(): Boolean {
        return tokens.isEmpty()
    }

    companion object : EmptyFactory<SessionData> {

        override fun empty(): SessionData {
            return SessionData(
                tokens = TokensData.empty()
            )
        }
    }
}
