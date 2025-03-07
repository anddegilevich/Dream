package and.degilevich.dream.shared.foundation.abstraction.id.ext

import and.degilevich.dream.shared.foundation.abstraction.id.Identified

inline fun <reified T> getEnumValueById(id: String?): T? where T : Enum<T>, T : Identified {
    return enumValues<T>().firstOrNull { it.id == id }
}

inline fun <reified T> getEnumValueByIdOrElse(
    id: String?,
    defaultValue: () -> T
): T where T : Enum<T>, T : Identified {
    return getEnumValueById(id = id) ?: defaultValue()
}