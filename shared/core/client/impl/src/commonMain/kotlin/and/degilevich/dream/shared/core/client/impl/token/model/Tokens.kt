package and.degilevich.dream.shared.core.client.impl.token.model

import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
internal data class Tokens(
    val accessToken: String,
    val refreshToken: String
) : EmptyState {
    override fun isEmpty(): Boolean {
        return accessToken.isEmpty()
    }

    companion object : EmptyFactory<Tokens> {
        override fun empty(): Tokens {
            return Tokens(
                accessToken = "",
                refreshToken = ""
            )
        }
    }
}
