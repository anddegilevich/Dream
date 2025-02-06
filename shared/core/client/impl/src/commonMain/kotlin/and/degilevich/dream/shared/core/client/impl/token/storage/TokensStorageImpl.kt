package and.degilevich.dream.shared.core.client.impl.token.storage

import and.degilevich.dream.shared.core.client.impl.token.model.Tokens
import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import and.degilevich.dream.shared.foundation.serialization.decodeFromJsonOrNull
import and.degilevich.dream.shared.foundation.serialization.encodeToJsonOrEmpty

internal class TokensStorageImpl(
    private val preferenceStorage: PreferenceStorage
) : TokensStorage {

    override fun save(value: Tokens) {
        preferenceStorage.save(
            key = TOKENS_PREFERENCE_STORAGE_KEY,
            value = value.encodeToJsonOrEmpty()
        )
    }

    override fun read(): Tokens? {
        return preferenceStorage.readString(key = TOKENS_PREFERENCE_STORAGE_KEY)?.decodeFromJsonOrNull<Tokens>()
    }

    override fun clear(): Boolean {
        return preferenceStorage.clear(key = TOKENS_PREFERENCE_STORAGE_KEY)
    }

    private companion object {
        const val TOKENS_PREFERENCE_STORAGE_KEY = "tokens"
    }
}