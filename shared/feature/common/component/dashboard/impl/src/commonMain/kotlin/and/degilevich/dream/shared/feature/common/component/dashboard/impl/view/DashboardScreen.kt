package and.degilevich.dream.shared.feature.common.component.dashboard.impl.view

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.child.DashboardItem
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.component.model.DashboardItemConfig
import and.degilevich.dream.shared.feature.common.component.dashboard.impl.preview.DashboardPreviewComponent
import and.degilevich.dream.shared.foundation.compose.ext.identifiedItems
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.shared.foundation.compose.preview.LightDarkPreviews
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.extensions.compose.lazyitems.ChildItemsLifecycleController
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.arkivanov.decompose.router.items.LazyChildItems

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun DashboardScreen(
    items: LazyChildItems<DashboardItemConfig, DashboardItem>,
    modifier: Modifier = Modifier
) {
    val itemsState by items.subscribeAsState()
    val lazyListState = rememberLazyListState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .themeBackground(),
        state = lazyListState,
        contentPadding = PaddingValues(top = 20.dp)
            .plus(WindowInsets.statusBars.asPaddingValues())
            .plus(WindowInsets.navigationBars.asPaddingValues())
    ) {
        identifiedItems(
            items = itemsState.items
        ) { config ->
            val item = remember(config) { items[config] }
            item.Render()
        }
    }

    ChildItemsLifecycleController(
        items = items,
        lazyListState = lazyListState,
        itemIndexConverter = { it }
    )
}

@LightDarkPreviews
@Composable
private fun DashboardScreenPreview() = ComposeAppTheme {
    DashboardPreviewComponent().Render()
}