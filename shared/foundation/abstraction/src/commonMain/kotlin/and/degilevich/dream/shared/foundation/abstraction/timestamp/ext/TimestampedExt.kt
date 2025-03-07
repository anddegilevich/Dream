package and.degilevich.dream.shared.foundation.abstraction.timestamp.ext

import and.degilevich.dream.shared.foundation.abstraction.equalizer.ext.distinctUntilUnequal
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.timestamp.Timestamped
import and.degilevich.dream.shared.foundation.abstraction.timestamp.equalizer.IdentifiedTimestampMetadataCollectionEqualizer
import and.degilevich.dream.shared.foundation.abstraction.timestamp.equalizer.IdentifiedTimestampMetadataEqualizer
import kotlinx.coroutines.flow.Flow

fun <T> Flow<List<T>>.distinctUntilListMetadataUnequal(): Flow<List<T>> where T : Identified, T : Timestamped {
    return this.distinctUntilUnequal(IdentifiedTimestampMetadataCollectionEqualizer())
}

fun <T> Flow<T>.distinctUntilMetadataUnequal(): Flow<T> where T : Identified, T : Timestamped {
    return this.distinctUntilUnequal(IdentifiedTimestampMetadataEqualizer())
}