package and.degilevich.dream.shared.core.storage.api

interface PreferenceStorage {
    fun save(key: String, value: String)
    fun readString(key: String): String?
    fun clear(key: String): Boolean
}