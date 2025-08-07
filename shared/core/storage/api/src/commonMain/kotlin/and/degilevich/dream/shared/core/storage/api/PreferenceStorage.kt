package and.degilevich.dream.shared.core.storage.api

interface PreferenceStorage {
    fun save(key: String, value: String)
    fun read(key: String): String?
    fun clear(key: String): Boolean
}