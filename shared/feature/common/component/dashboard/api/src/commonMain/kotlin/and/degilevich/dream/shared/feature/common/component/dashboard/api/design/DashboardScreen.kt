package and.degilevich.dream.shared.feature.common.component.dashboard.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.album.component.releases.api.design.AlbumReleasesCarousel
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.child.DashboardItem
import and.degilevich.dream.shared.foundation.compose.ext.identifiedItems
import and.degilevich.dream.shared.foundation.compose.ext.plus
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
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

@OptIn(ExperimentalDecomposeApi::class)
@Composable
fun DashboardScreen(
    component: DashboardComponent,
    modifier: Modifier = Modifier
) {

    val items by component.items.subscribeAsState()
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
        identifiedItems(items = items.items) { config ->
            val itemComponent = remember(config) { component.items[config] }

            when (itemComponent) {
                is DashboardItem.AlbumReleases -> {
                    AlbumReleasesCarousel(
                        state = itemComponent.state(),
                        onIntent = itemComponent::handleIntent
                    )
                }
            }
        }
    }

    ChildItemsLifecycleController(
        items = component.items,
        lazyListState = lazyListState,
        itemIndexConverter = { it }
    )
}