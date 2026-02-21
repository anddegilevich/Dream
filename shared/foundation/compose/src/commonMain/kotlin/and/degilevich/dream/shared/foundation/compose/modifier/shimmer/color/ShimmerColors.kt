package and.degilevich.dream.shared.foundation.compose.modifier.shimmer.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
interface ShimmerColors {
    val flash: Color
    val background: Color

    @Immutable
    object Default : ShimmerColors {
        override val flash: Color = Color.White
        override val background: Color = Color.LightGray
    }
}