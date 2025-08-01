package and.degilevich.dream.shared.feature.track.component.details.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsIntent
import and.degilevich.dream.shared.feature.track.component.details.api.component.model.TrackDetailsUIState
import and.degilevich.dream.shared.feature.track.component.details.api.design.skeleton.SkeletonTrackDetailsInfoLayout
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.SkeletonCrossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun TrackDetailsScreen(
    state: TrackDetailsUIState,
    modifier: Modifier = Modifier,
    onIntent: (TrackDetailsIntent) -> Unit
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
    ) {
        Spacer(
            modifier = Modifier
                .padding(top = 12.dp)
                .statusBarsPadding()
        )
        IconButton(
            modifier = Modifier.size(24.dp),
            painter = painterResource(Res.images.ic_back)
        ) {
            onIntent(TrackDetailsIntent.OnBackClicked)
        }
        Space(height = 20.dp)
        SkeletonCrossfade(
            skeleton = state.info,
            loadingContent = {
                SkeletonTrackDetailsInfoLayout()
            },
            content = { data ->
                TrackDetailsInfoLayout(
                    data = data
                )
            }
        )
        Spacer(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .navigationBarsPadding()
        )
    }
}