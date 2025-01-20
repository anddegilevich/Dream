package and.degilevich.dream.shared.foundation.model.id.ext

import and.degilevich.dream.shared.foundation.model.id.Identified

inline fun <reified T> getEnumValueById(id: String): T? where T : Enum<T>, T : Identified {
    return enumValues<T>().firstOrNull { it.id == id }
}