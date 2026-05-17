package and.degilevich.dream.shared.foundation.abstraction.id

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class AnyIdentifier(override val value: String) : Identifier {

    companion object : EmptyFactory<AnyIdentifier> {

        override fun empty(): AnyIdentifier {
            return AnyIdentifier(value = "")
        }
    }
}