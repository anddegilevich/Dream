package and.degilevich.dream.shared.foundation.primitive.stringBuilder

fun StringBuilder.appendSpace(): StringBuilder {
    append(" ")
    return this
}

fun StringBuilder.appendUnderline(): StringBuilder {
    append("_")
    return this
}

fun StringBuilder.appendCommaSpace(): StringBuilder {
    append(", ")
    return this
}

fun StringBuilder.appendDivider(): StringBuilder {
    append(" | ")
    return this
}