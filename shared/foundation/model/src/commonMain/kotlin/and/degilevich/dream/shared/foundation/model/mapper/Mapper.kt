package and.degilevich.dream.shared.foundation.model.mapper

interface Mapper<From, To> {
    fun map(item: From): To
}