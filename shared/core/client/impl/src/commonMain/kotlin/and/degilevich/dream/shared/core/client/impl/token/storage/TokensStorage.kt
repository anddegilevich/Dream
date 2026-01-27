package and.degilevich.dream.shared.core.client.impl.token.storage

import and.degilevich.dream.shared.core.client.impl.token.model.Tokens

internal interface TokensStorage {
    suspend fun save(value: Tokens)
    suspend fun read(): Tokens?
    suspend fun clear()
}