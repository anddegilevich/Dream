package and.degilevich.dream.shared.feature.user.model.artifact.api.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class UserId(override val value: String) : Identifier {

    companion object : EmptyFactory<UserId> {

        override fun empty(): UserId {
            return UserId(value = "")
        }
    }
}
