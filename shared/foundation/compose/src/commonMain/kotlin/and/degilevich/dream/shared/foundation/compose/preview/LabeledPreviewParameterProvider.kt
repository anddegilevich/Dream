package and.degilevich.dream.shared.foundation.compose.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider

abstract class LabeledPreviewParameterProvider<T : Any> : PreviewParameterProvider<T> {

    abstract val labeledValues: List<LabeledPreviewParameter<T>>

    final override val values get() = labeledValues.asSequence().map { it.value }

    final override fun getDisplayName(index: Int): String? {
        return labeledValues.getOrNull(index)?.label
    }

    protected infix fun String.to(value: T) = LabeledPreviewParameter(
        label = this,
        value = value
    )
}