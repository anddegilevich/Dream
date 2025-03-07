package and.degilevich.dream.shared.foundation.model.timestamp.equalizer

import and.degilevich.dream.shared.foundation.model.equalizer.Equalizer
import and.degilevich.dream.shared.foundation.model.id.Identified
import and.degilevich.dream.shared.foundation.model.timestamp.Timestamped

class IdentifiedTimestampMetadataEqualizer<T> : Equalizer<T> where T : Identified, T : Timestamped {

    override fun compare(one: T, other: T): Boolean {
        val isSameIds = one.id == other.id
        val isSameModified = one.modified == other.modified
        return isSameIds && isSameModified
    }
}