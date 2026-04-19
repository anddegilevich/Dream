package and.degilevich.dream.shared.feature.artist.model.artifact.api.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class ArtistId(override val value: String) : Identifier {

    companion object : EmptyFactory<ArtistId> {

        override fun empty(): ArtistId {
            return ArtistId(value = "")
        }
    }
}