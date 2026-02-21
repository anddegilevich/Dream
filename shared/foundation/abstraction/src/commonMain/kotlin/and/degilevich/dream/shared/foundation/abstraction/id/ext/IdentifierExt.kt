package and.degilevich.dream.shared.foundation.abstraction.id.ext

import and.degilevich.dream.shared.foundation.abstraction.id.Identifier

fun String?.asId(): Identifier {
    return Identifier(id = this.orEmpty())
}