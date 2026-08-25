package and.degilevich.dream.shared.core.service.api.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class TokensData(
    val accessToken: String,
    val refreshToken: String
) : EmptyState {

    override fun isEmpty(): Boolean {
        return accessToken.isEmpty()
    }

    companion object : EmptyFactory<TokensData> {

        override fun empty(): TokensData {
            return TokensData(
                accessToken = "",
                refreshToken = ""
            )
        }
    }
}
