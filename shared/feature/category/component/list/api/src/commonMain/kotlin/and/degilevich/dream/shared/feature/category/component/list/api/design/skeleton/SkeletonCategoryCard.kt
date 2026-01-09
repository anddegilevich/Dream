package and.degilevich.dream.shared.feature.category.component.list.api.design.skeleton

import and.degilevich.dream.shared.design.system.modifier.themeShimmer
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonCategoryCard(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .size(
                height = 108.dp,
                width = 192.dp
            )
            .clip(RoundedCornerShape(4.dp))
            .themeShimmer()
    )
}