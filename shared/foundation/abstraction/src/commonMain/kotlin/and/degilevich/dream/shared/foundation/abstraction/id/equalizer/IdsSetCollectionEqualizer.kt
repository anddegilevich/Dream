package and.degilevich.dream.shared.foundation.abstraction.id.equalizer

import and.degilevich.dream.shared.foundation.abstraction.equalizer.collection.CollectionEqualizer
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.ext.ids

class IdsSetCollectionEqualizer<T : Identified> : CollectionEqualizer<T> {
    override fun compare(
        one: Collection<T>,
        other: Collection<T>
    ): Boolean {
        return one.ids().toSet() == other.ids().toSet()
    }
}