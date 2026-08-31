package and.degilevich.dream.shared.feature.playlist.model.artifact.api.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class PlaylistId(override val value: String) : Identifier {

    companion object : EmptyFactory<PlaylistId> {

        override fun empty(): PlaylistId {
            return PlaylistId(value = "")
        }
    }
}
