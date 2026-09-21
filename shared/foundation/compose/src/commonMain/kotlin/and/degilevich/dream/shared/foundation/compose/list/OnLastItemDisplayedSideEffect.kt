package and.degilevich.dream.shared.foundation.compose.list

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

@Composable
fun OnLastItemDisplayedSideEffect(
    listState: LazyListState,
    threshold: Int,
    onLastItemDisplayed: () -> Unit
) {
    val isLastItemDisplayed by remember(listState, threshold) {
        derivedStateOf {
            val layoutInfo = listState.layoutInfo
            val lastVisibleIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: return@derivedStateOf false
            val totalItemsCount = layoutInfo.totalItemsCount
            totalItemsCount > 0 && lastVisibleIndex >= totalItemsCount - threshold - 1
        }
    }

    LaunchedEffect(isLastItemDisplayed) {
        if (isLastItemDisplayed) {
            onLastItemDisplayed()
        }
    }
}
