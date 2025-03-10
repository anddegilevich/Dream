package and.degilevich.dream.shared.foundation.abstraction.equalizer.ext

import and.degilevich.dream.shared.foundation.abstraction.equalizer.collection.CollectionEqualizer
import and.degilevich.dream.shared.foundation.abstraction.equalizer.Equalizer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

fun <T> Flow<T>.distinctUntilUnequal(equalizer: Equalizer<T>): Flow<T> {
    return this.distinctUntilChanged { old, new ->
        equalizer.compare(old, new)
    }
}

fun <T> Flow<List<T>>.distinctUntilUnequal(equalizer: CollectionEqualizer<T>): Flow<List<T>> {
    return this.distinctUntilChanged { old, new ->
        equalizer.compare(old, new)
    }
}