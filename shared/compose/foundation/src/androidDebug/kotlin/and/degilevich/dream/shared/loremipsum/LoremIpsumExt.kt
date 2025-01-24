package and.degilevich.dream.shared.loremipsum

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum

@Composable
fun rememberLoremIpsumText(wordsCount: Int): String {
    return remember { LoremIpsum(words = wordsCount).values.joinToString() }
}