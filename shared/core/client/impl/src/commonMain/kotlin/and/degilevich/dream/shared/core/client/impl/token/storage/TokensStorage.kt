package and.degilevich.dream.shared.core.client.impl.token.storage

import and.degilevich.dream.shared.core.client.impl.token.model.Tokens

internal interface TokensStorage {
    fun save(value: Tokens)
    fun read(): Tokens?
    fun clear(): Boolean
}