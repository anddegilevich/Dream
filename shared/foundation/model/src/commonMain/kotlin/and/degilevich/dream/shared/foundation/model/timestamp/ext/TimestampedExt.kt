package and.degilevich.dream.shared.foundation.model.timestamp.ext

import and.degilevich.dream.shared.foundation.model.equalizer.ext.distinctUntilUnequal
import and.degilevich.dream.shared.foundation.model.id.Identified
import and.degilevich.dream.shared.foundation.model.timestamp.Timestamped
import and.degilevich.dream.shared.foundation.model.timestamp.equalizer.IdentifiedTimestampMetadataCollectionEqualizer
import and.degilevich.dream.shared.foundation.model.timestamp.equalizer.IdentifiedTimestampMetadataEqualizer
import kotlinx.coroutines.flow.Flow

fun <T> Flow<List<T>>.distinctUntilListMetadataUnequal(): Flow<List<T>> where T : Identified, T : Timestamped {
    return this.distinctUntilUnequal(IdentifiedTimestampMetadataCollectionEqualizer())
}

fun <T> Flow<T>.distinctUntilMetadataUnequal(): Flow<T> where T : Identified, T : Timestamped {
    return this.distinctUntilUnequal(IdentifiedTimestampMetadataEqualizer())
}