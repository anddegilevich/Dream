package and.degilevich.dream.shared.foundation.compose.ext

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable

fun <T : Identified> LazyListScope.identifiedItems(
    items: List<T>,
    itemContent: @Composable LazyItemScope.(item: T) -> Unit,
) {
    items(
        items = items,
        key = { item ->
            item.id
        }
    ) { item ->
        itemContent(item)
    }
}

fun <T : Identified> LazyListScope.identifiedItemsIndexed(
    items: List<T>,
    itemContent: @Composable LazyItemScope.(index: Int, item: T) -> Unit,
) {
    itemsIndexed(
        items = items,
        key = { _, item ->
            item.id
        }
    ) { index, item ->
        itemContent(index, item)
    }
}

fun <T : Identified> LazyGridScope.identifiedItems(
    items: List<T>,
    itemContent: @Composable LazyGridItemScope.(item: T) -> Unit,
) {
    items(
        items = items,
        key = { item ->
            item.id
        }
    ) { item ->
        itemContent(item)
    }
}

fun <T : Identified> LazyGridScope.identifiedItemsIndexed(
    items: List<T>,
    itemContent: @Composable LazyGridItemScope.(index: Int, item: T) -> Unit,
) {
    itemsIndexed(
        items = items,
        key = { _, item ->
            item.id
        }
    ) { index, item ->
        itemContent(index, item)
    }
}