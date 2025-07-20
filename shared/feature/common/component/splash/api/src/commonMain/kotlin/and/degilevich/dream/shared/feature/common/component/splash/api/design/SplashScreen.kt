package and.degilevich.dream.shared.feature.common.component.splash.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.system.modifier.themeBackground
import and.degilevich.dream.shared.design.theme.api.Theme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .themeBackground(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(144.dp),
            painter = painterResource(Res.images.ic_duck),
            tint = Theme.colors.common.brandGreen,
            contentDescription = null,
        )
    }
}