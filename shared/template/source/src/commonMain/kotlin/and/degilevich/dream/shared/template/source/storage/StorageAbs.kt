package and.degilevich.dream.shared.template.source.storage

import and.degilevich.dream.shared.core.storage.api.PreferenceStorage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class StorageAbs<T>(
    private val key: String,
    private val encoder: (T) -> String?,
    private val decoder: (String?) -> T?
) : Storage<T>, KoinComponent {

    private val preferenceStorage: PreferenceStorage by inject()

    override fun save(value: T) {
        val encodedValue = encoder(value) ?: return
        preferenceStorage.save(
            key = key,
            value = encodedValue
        )
    }

    override fun clear(): Boolean {
        return preferenceStorage.clear(key = key)
    }

    override fun read(): T? {
        val storedValue = preferenceStorage.readString(key = key)
        return decoder(storedValue)
    }
}