package and.degilevich.dream.shared.feature.track.model.artifact.api.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class TrackId(override val value: String) : Identifier {

    companion object : EmptyFactory<TrackId> {

        override fun empty(): TrackId {
            return TrackId(value = "")
        }
    }
}