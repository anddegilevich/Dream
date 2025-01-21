package and.degilevich.dream.shared.common.source.storage

interface Storage<T> {
    fun save(value: T)
    fun read(): T?
    fun clear(): Boolean
}