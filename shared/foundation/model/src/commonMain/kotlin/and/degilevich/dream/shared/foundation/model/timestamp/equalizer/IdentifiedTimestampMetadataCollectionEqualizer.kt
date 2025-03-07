package and.degilevich.dream.shared.foundation.model.timestamp.equalizer

import and.degilevich.dream.shared.foundation.model.equalizer.collection.CollectionEqualizer
import and.degilevich.dream.shared.foundation.model.id.Identified
import and.degilevich.dream.shared.foundation.model.id.equalizer.IdsSetCollectionEqualizer
import and.degilevich.dream.shared.foundation.model.timestamp.Timestamped

class IdentifiedTimestampMetadataCollectionEqualizer<T> : CollectionEqualizer<T> where T : Identified, T : Timestamped {

    private val idsSetCollectionEqualizer = IdsSetCollectionEqualizer<T>()

    override fun compare(
        one: Collection<T>,
        other: Collection<T>
    ): Boolean {
        return when {
            one.size != other.size -> {
                false
            }

            !idsSetCollectionEqualizer.compare(
                one = one,
                other = other
            ) -> {
                false
            }

            else -> {
                listOf(one, other)
                    .flatten()
                    .groupBy { item -> item.id }
                    .all { entry ->
                        entry.value.map { values -> values.modified }.distinct().size == 1
                    }
            }
        }
    }
}