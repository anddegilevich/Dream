package and.degilevich.dream.shared.foundation.abstraction.mapper

interface Mapper<in From, out To> {
    fun map(item: From): To
    fun map(items: Iterable<From>): List<To> {
        return items.map(::map)
    }
    fun map(items: Sequence<From>): Sequence<To> {
        return items.map(::map)
    }
}