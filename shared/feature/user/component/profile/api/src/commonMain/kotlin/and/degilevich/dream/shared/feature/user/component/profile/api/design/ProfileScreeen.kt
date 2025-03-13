package and.degilevich.dream.shared.feature.user.component.profile.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.button.PrimaryButton
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileUIState
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.scaleOnClick
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun ProfileScreen(
    state: ProfileUIState,
    onIntent: (ProfileIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    val iconInteractionSource = remember { MutableInteractionSource() }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Theme.colors.background)
            .safeContentPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Space(height = 16.dp)
        AsyncImage(
            modifier = Modifier
                .scaleOnClick(interactionSource = iconInteractionSource)
                .clip(CircleShape)
                .clickableWithDebounce(interactionSource = iconInteractionSource) {
                    onIntent(ProfileIntent.OnIconClicked)
                }
                .size(300.dp)
                .background(Theme.colors.iconPlaceholderBackground),
            model = state.iconUri,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Space(height = 16.dp)
        PrimaryButton(
            text = "Add photos",
            onClicked = {
                onIntent(ProfileIntent.OnAddPhotoClicked)
            }
        )
        Space(height = 16.dp)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                start = 16.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = state.profilePhotos,
                key = { it.id }
            ) { item ->
                AsyncImage(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Theme.colors.iconPlaceholderBackground),
                    model = item.uri,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }
        Space(height = 16.dp)
        PrimaryButton(
            text = stringResource(Res.strings.button_back),
            onClicked = {
                onIntent(ProfileIntent.OnBackClicked)
            }
        )
    }
}