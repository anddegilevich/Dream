package and.degilevich.dream.shared.feature.album.model.artifact.api.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class AlbumId(override val value: String) : Identifier {

    companion object : EmptyFactory<AlbumId> {

        override fun empty(): AlbumId {
            return AlbumId(value = "")
        }
    }
}