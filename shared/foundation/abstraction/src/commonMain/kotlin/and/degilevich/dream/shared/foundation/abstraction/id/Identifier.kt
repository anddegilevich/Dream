package and.degilevich.dream.shared.foundation.abstraction.id

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@JvmInline
@Serializable
value class Identifier(val id: String) : EmptyState {

    override fun isEmpty(): Boolean {
        return id.isEmpty()
    }

    companion object : EmptyFactory<Identifier> {

        override fun empty(): Identifier {
            return Identifier(id = "")
        }

        @OptIn(ExperimentalUuidApi::class)
        fun uuid(): Identifier {
            return Identifier(
                id = Uuid.random().toString()
            )
        }
    }
}