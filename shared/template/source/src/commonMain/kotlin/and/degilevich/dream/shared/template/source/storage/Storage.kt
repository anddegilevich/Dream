package and.degilevich.dream.shared.template.source.storage

interface Storage<T> {
    fun save(value: T)
    fun read(): Result<T>
    fun clear(): Boolean
}