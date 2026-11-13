package and.degilevich.dream.shared.feature.common.component.splash.impl.view

import and.degilevich.dream.Res
import and.degilevich.dream.ic_duck
import and.degilevich.dream.ic_spotify_full_logo
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashIntent
import and.degilevich.dream.shared.feature.common.component.splash.impl.view.semantic.SplashScreenSemantic
import and.degilevich.dream.label_powered_by
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

@Composable
fun SplashScreen(
    onIntent: (SplashIntent) -> Unit,
    modifier: Modifier = Modifier
) {
    val currentOnIntent by rememberUpdatedState(onIntent)
    var isVisibleAttribution by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        isVisibleAttribution = true
        delay(ATTRIBUTION_APPEAR_DURATION + FINAL_DELAY_DURATION)
        currentOnIntent(SplashIntent.OnIntroFinished)
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .themeBackground(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .testTag(SplashScreenSemantic.TEST_TAG_LOGO)
                    .size(144.dp),
                painter = painterResource(Res.images.ic_duck),
                tint = Theme.colors.common.brand,
                contentDescription = null,
            )
            AnimatedVisibility(
                visible = isVisibleAttribution,
                enter = fadeIn(
                    animationSpec = tween(
                        durationMillis = ATTRIBUTION_APPEAR_DURATION.inWholeMilliseconds.toInt()
                    )
                ) + expandVertically(
                    animationSpec = tween(
                        durationMillis = ATTRIBUTION_APPEAR_DURATION.inWholeMilliseconds.toInt()
                    )
                )
            ) {
                SplashAttribution(
                    modifier = Modifier.testTag(SplashScreenSemantic.TEST_TAG_ATTRIBUTION)
                )
            }
        }
    }
}

@Composable
private fun SplashAttribution(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = stringResource(Res.strings.label_powered_by),
            style = Theme.typography.main,
            color = Theme.colors.icon.secondary
        )
        Icon(
            modifier = Modifier.size(
                width = 88.dp,
                height = 24.dp
            ),
            painter = painterResource(Res.images.ic_spotify_full_logo),
            tint = Theme.colors.text.secondary,
            contentDescription = null
        )
    }
}

private val ATTRIBUTION_APPEAR_DURATION = 600.milliseconds
private val FINAL_DELAY_DURATION = 1.2.seconds

@PreviewLightDark
@Composable
private fun SplashScreenPreview() = ComposeAppTheme {
    SplashScreen(
        onIntent = {}
    )
}
