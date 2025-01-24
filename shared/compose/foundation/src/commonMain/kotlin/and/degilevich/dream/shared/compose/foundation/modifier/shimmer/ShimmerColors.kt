package and.degilevich.dream.shared.compose.foundation.modifier.shimmer

import androidx.compose.ui.graphics.Color

interface ShimmerColors {
    val flash: Color
    val background: Color

    object Default : ShimmerColors {
        override val flash: Color = Color(0xFFFBFBFB)
        override val background: Color = Color(0xFFE4E8EB)
    }
}