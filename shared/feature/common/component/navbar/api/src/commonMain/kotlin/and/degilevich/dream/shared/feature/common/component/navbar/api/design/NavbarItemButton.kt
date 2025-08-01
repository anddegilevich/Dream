package and.degilevich.dream.shared.feature.common.component.navbar.api.design

import and.degilevich.dream.shared.design.system.indication.themeRipple
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.model.NavbarItemUIData
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.clickable.clickableWithDebounce
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource

@Composable
fun NavbarItemButton(
    data: NavbarItemUIData,
    modifier: Modifier = Modifier,
    onClicked: (id: String) -> Unit
) {
    val iconColor by animateColorAsState(
        targetValue = if (data.isSelected) {
            Theme.colors.icon.primary
        } else {
            Theme.colors.icon.secondary
        }
    )

    Column(
        modifier = modifier
            .clickableWithDebounce(
                indication = themeRipple()
            ) {
                onClicked(data.id)
            }
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(data.icon),
            tint = iconColor,
            contentDescription = null
        )
        Space(height = 4.dp)
        Text(
            text = data.text,
            style = Theme.typography.label,
            color = Theme.colors.text.secondary
        )
    }
}