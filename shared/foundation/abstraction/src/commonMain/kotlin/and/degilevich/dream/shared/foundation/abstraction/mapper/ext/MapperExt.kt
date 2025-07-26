package and.degilevich.dream.shared.foundation.abstraction.mapper.ext

import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

fun <From, To> From.mapWith(mapper: Mapper<From, To>): To {
    return mapper.map(this)
}

fun <From, To> Iterable<From>.mapWith(mapper: Mapper<From, To>): List<To> {
    return mapper.map(this)
}

fun <From, To> Sequence<From>.mapWith(mapper: Mapper<From, To>): Sequence<To> {
    return map(mapper::map)
}

fun <From, To> Flow<From>.mapWith(mapper: Mapper<From, To>): Flow<To> {
    return map(mapper::map)
}