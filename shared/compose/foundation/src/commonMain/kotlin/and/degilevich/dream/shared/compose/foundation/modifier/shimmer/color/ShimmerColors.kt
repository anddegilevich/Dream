package and.degilevich.dream.shared.compose.foundation.modifier.shimmer.color

import androidx.compose.ui.graphics.Color

interface ShimmerColors {
    val flash: Color
    val background: Color

    object Default : ShimmerColors {
        override val flash: Color = Color.White
        override val background: Color = Color.Gray
    }
}