package and.degilevich.dream.shared.foundation.model.id.ext

import and.degilevich.dream.shared.foundation.model.equalizer.ext.distinctUntilUnequal
import and.degilevich.dream.shared.foundation.model.id.Identified
import and.degilevich.dream.shared.foundation.model.id.equalizer.IdsSetCollectionEqualizer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

fun <T : Identified> Flow<List<T>>.distinctUntilIdsUnequal(): Flow<List<T>> {
    return this.distinctUntilUnequal(IdsSetCollectionEqualizer())
}

fun <T : Identified> Flow<T>.distinctUntilIdChanged(): Flow<T> {
    return this.distinctUntilChanged { old, new ->
        old.id == new.id
    }
}