package and.degilevich.dream.shared.feature.common.component.dashboard.api.design

import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardIntent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.model.DashboardUIState
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    state: DashboardUIState,
    onIntent: (DashboardIntent) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
    ) {

    }
}