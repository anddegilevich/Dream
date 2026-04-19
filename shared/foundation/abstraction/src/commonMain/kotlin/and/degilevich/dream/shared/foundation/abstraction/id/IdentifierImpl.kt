package and.degilevich.dream.shared.foundation.abstraction.id

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
internal value class IdentifierImpl(override val value: String) : Identifier {

    companion object : EmptyFactory<IdentifierImpl> {

        override fun empty(): IdentifierImpl {
            return IdentifierImpl(value = "")
        }
    }
}