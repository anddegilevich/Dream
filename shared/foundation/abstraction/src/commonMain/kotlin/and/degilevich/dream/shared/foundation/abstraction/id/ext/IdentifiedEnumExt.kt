package and.degilevich.dream.shared.foundation.abstraction.id.ext

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

inline fun <reified T> getEnumValueById(id: Identifier?): T? where T : Enum<T>, T : Identified {
    return enumValues<T>().firstOrNull { it.id == id }
}

inline fun <reified T> getEnumValueByIdOrElse(
    id: Identifier?,
    defaultValue: () -> T
): T where T : Enum<T>, T : Identified {
    return getEnumValueById(id = id) ?: defaultValue()
}