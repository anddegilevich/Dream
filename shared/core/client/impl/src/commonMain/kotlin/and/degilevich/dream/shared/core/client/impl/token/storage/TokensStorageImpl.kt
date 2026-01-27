package and.degilevich.dream.shared.core.client.impl.token.storage

import and.degilevich.dream.shared.core.client.impl.token.model.Tokens
import and.degilevich.dream.shared.core.storage.api.PreferenceStorage

internal class TokensStorageImpl(
    private val preferenceStorage: PreferenceStorage
) : TokensStorage {

    override suspend fun save(value: Tokens) {
        preferenceStorage.save(
            key = TOKENS_PREFERENCE_STORAGE_KEY,
            serializer = Tokens.serializer(),
            value = value
        )
    }

    override suspend fun read(): Tokens? {
        return preferenceStorage.read(
            key = TOKENS_PREFERENCE_STORAGE_KEY,
            serializer = Tokens.serializer()
        )
    }

    override suspend fun clear() {
        preferenceStorage.clear(key = TOKENS_PREFERENCE_STORAGE_KEY)
    }

    private companion object {
        const val TOKENS_PREFERENCE_STORAGE_KEY = "tokens"
    }
}