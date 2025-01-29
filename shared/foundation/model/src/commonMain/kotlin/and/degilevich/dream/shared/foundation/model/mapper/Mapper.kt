package and.degilevich.dream.shared.foundation.model.mapper

interface Mapper<From, To> {
    fun map(item: From): To
    fun map(items: Iterable<From>): List<To> {
        return items.map(::map)
    }
}