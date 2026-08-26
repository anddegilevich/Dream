package and.degilevich.dream.shared.foundation.compose.preview

class BooleanPreviewProvider : LabeledPreviewParameterProvider<Boolean>() {

    override val labeledValues: List<LabeledPreviewParameter<Boolean>> = listOf(
        "True" to true,
        "False" to false,
    )
}