package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.IconButton
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsIntent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.model.ArtistDetailsUIState
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.feature.artist.design.api.design.ArtistIcon
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun ArtistDetailsScreen(
    state: ArtistDetailsUIState,
    onIntent: (ArtistDetailsIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .themeBackground()
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
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
            onIntent(ArtistDetailsIntent.OnBackClicked)
        }
        Space(height = 12.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ArtistIcon(
                modifier = Modifier
                    .size(120.dp),
                iconUrl = state.iconUrl
            )
            Space(width = 20.dp)
            Text(
                text = state.name,
                color = Theme.colors.text.primary,
                style = Theme.typography.h2
            )
        }
        Spacer(
            modifier = Modifier
                .padding(bottom = 20.dp)
                .navigationBarsPadding()
        )
    }
}