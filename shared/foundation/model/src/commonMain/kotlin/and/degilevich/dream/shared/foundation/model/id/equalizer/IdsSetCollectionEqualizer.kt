package and.degilevich.dream.shared.foundation.model.id.equalizer

import and.degilevich.dream.shared.foundation.model.equalizer.collection.CollectionEqualizer
import and.degilevich.dream.shared.foundation.model.id.Identified
import and.degilevich.dream.shared.foundation.model.id.ext.ids

class IdsSetCollectionEqualizer<T : Identified> : CollectionEqualizer<T> {
    override fun compare(
        one: Collection<T>,
        other: Collection<T>
    ): Boolean {
        return one.ids().toSet() == other.ids().toSet()
    }
}