package and.degilevich.dream.shared.foundation.compose.modifier.skeleton

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

fun <T> LazyListScope.skeletonItems(
    skeleton: Skeleton<List<T>>,
    key: ((item: T) -> Any)? = null,
    loadingContent: @Composable LazyItemScope.() -> Unit,
    itemContent: @Composable LazyItemScope.(item: T) -> Unit,
) {
    when (skeleton) {
        is Skeleton.Loading -> {
            item { loadingContent() }
        }

        is Skeleton.Value -> {
            items(
                items = skeleton.value,
                key = key
            ) { item -> itemContent(item) }
        }
    }
}

fun <T> LazyListScope.skeletonItems(
    skeleton: Skeleton<List<T>>,
    key: ((item: T) -> Any)? = null,
    loadingItemsCount: Int,
    loadingItemContent: @Composable LazyItemScope.() -> Unit,
    itemContent: @Composable LazyItemScope.(item: T) -> Unit,
) {
    when (skeleton) {
        is Skeleton.Loading -> {
            items(
                count = loadingItemsCount
            ) { loadingItemContent() }
        }

        is Skeleton.Value -> {
            items(
                items = skeleton.value,
                key = key
            ) { item -> itemContent(item) }
        }
    }
}

fun <T : Identified> LazyListScope.identifiedSkeletonItems(
    skeleton: Skeleton<List<T>>,
    loadingContent: @Composable LazyItemScope.() -> Unit,
    itemContent: @Composable LazyItemScope.(item: T) -> Unit,
) {
    skeletonItems(
        skeleton = skeleton,
        key = { item -> item.id.id },
        loadingContent = loadingContent,
        itemContent = itemContent
    )
}

fun <T : Identified> LazyListScope.identifiedSkeletonItems(
    skeleton: Skeleton<List<T>>,
    loadingItemsCount: Int,
    loadingItemContent: @Composable LazyItemScope.() -> Unit,
    itemContent: @Composable LazyItemScope.(item: T) -> Unit,
) {
    skeletonItems(
        skeleton = skeleton,
        key = { item -> item.id.id },
        loadingItemsCount = loadingItemsCount,
        loadingItemContent = loadingItemContent,
        itemContent = itemContent
    )
}