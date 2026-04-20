package and.degilevich.dream.shared.foundation.compose.preview

import androidx.compose.runtime.Immutable

@Immutable
data class LabeledPreviewParameter<T : Any>(
    val label: String,
    val value: T
)