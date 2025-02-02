package and.degilevich.dream.shared.compose.theme.api

import and.degilevich.dream.shared.compose.theme.api.colors.DreamColors
import and.degilevich.dream.shared.compose.theme.impl.color.DarkThemeDreamColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember

@Composable
fun DreamTheme(
    content: @Composable () -> Unit
) {
    val colors: DreamColors = remember { DarkThemeDreamColors() }

    CompositionLocalProvider(
        LocalColors provides colors,
        content
    )
}

@Suppress("CompositionLocalAllowlist")
internal val LocalColors: ProvidableCompositionLocal<DreamColors> = compositionLocalOf { DarkThemeDreamColors() }