package and.degilevich.dream.shared.foundation.abstraction.id.ext

import and.degilevich.dream.shared.foundation.abstraction.equalizer.ext.distinctUntilUnequal
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.equalizer.IdsSetCollectionEqualizer
import kotlinx.coroutines.flow.Flow

fun <T : Identified> Flow<List<T>>.distinctUntilIdsUnequal(): Flow<List<T>> {
    return this.distinctUntilUnequal(IdsSetCollectionEqualizer())
}
