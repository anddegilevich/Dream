package and.degilevich.dream.shared.foundation.abstraction.id

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@JvmInline
@Serializable
value class Identifier(val value: String) : EmptyState {

    override fun isEmpty(): Boolean {
        return value.isEmpty()
    }

    override fun toString(): String = value

    companion object : EmptyFactory<Identifier> {

        override fun empty(): Identifier {
            return Identifier(value = "")
        }

        @OptIn(ExperimentalUuidApi::class)
        fun uuid(): Identifier {
            return Identifier(
                value = Uuid.random().toString()
            )
        }
    }
}