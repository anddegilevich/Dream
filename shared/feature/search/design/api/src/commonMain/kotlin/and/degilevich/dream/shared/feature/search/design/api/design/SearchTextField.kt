package and.degilevich.dream.shared.feature.search.design.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.focus.clearFocusOnImeDismiss
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun SearchTextField(
    value: TextFieldValue,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChanged: (value: TextFieldValue) -> Unit,
) {
    val isEmptyInput = remember(value) { value.text.isEmpty() }
    val shape = remember { RoundedCornerShape(12.dp) }

    BasicTextField(
        modifier = modifier.clearFocusOnImeDismiss(),
        value = value,
        onValueChange = onValueChanged,
        singleLine = true,
        enabled = isEnabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource,
        textStyle = Theme.typography.field.copy(
            color = Theme.colors.field.search.text
        ),
        cursorBrush = SolidColor(Theme.colors.field.search.cursor)
    ) { innerTextField ->
        Row(
            modifier = Modifier
                .background(
                    color = Theme.colors.field.search.background,
                    shape = shape
                )
                .padding(
                    horizontal = 12.dp,
                    vertical = 8.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(12.dp),
                painter = painterResource(Res.images.ic_search),
                contentDescription = null,
                tint = Theme.colors.field.search.icon
            )
            Space(8.dp)
            Box(
                modifier = Modifier.heightIn(min = 20.dp)
            ) {
                androidx.compose.animation.AnimatedVisibility(
                    visible = isEmptyInput,
                    enter = expandHorizontally(
                        animationSpec = tween()
                    ) + fadeIn(
                        animationSpec = tween()
                    ),
                    exit = shrinkHorizontally(
                        animationSpec = tween()
                    ) + fadeOut(
                        animationSpec = tween(PLACEHOLDER_FADE_OUT_DURATION)
                    )
                ) {
                    Text(
                        text = placeholder,
                        style = Theme.typography.field,
                        color = Theme.colors.field.search.placeholder
                    )
                }
                innerTextField()
            }
        }
    }
}

@Composable
fun SearchTextField(
    value: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onValueChanged: (value: String) -> Unit,
) {
    var internalTextFieldValue by remember { mutableStateOf(TextFieldValue(text = value)) }
    val textFieldValue = remember(internalTextFieldValue, value) { internalTextFieldValue.copy(text = value) }

    SearchTextField(
        modifier = modifier,
        value = textFieldValue,
        onValueChanged = { newValue ->
            internalTextFieldValue = newValue
            if (value != newValue.text) {
                onValueChanged(newValue.text)
            }
        },
        placeholder = placeholder,
        isEnabled = isEnabled,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        interactionSource = interactionSource
    )
}

private const val PLACEHOLDER_FADE_OUT_DURATION = 200