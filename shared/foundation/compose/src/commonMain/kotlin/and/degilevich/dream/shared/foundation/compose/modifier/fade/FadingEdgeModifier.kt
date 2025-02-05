package and.degilevich.dream.shared.foundation.compose.modifier.fade

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer

fun Modifier.fadingBottom(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.verticalGradient(
            1f - fadeFraction to Color.White,
            1f to Color.Transparent
        )
    )
}

fun Modifier.fadingTop(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.verticalGradient(
            0f to Color.Transparent,
            fadeFraction to Color.White
        )
    )
}
fun Modifier.fadingStart(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.horizontalGradient(
            0f to Color.Transparent,
            fadeFraction to Color.White,

        )
    )
}

fun Modifier.fadingEnd(fadeFraction: Float = DEFAULT_FADE_FRACTION): Modifier {
    return this.fadingEdge(
        Brush.horizontalGradient(
            1f - fadeFraction to Color.White,
            1f to Color.Transparent
        )
    )
}

private fun Modifier.fadingEdge(brush: Brush): Modifier {
    return this.graphicsLayer(compositingStrategy = CompositingStrategy.Offscreen)
        .drawWithContent {
            drawContent()
            drawRect(
                brush = brush,
                blendMode = BlendMode.DstIn
            )
        }
}

private const val DEFAULT_FADE_FRACTION = 0.1f