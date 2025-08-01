package and.degilevich.dream.shared.feature.search.design.api.design.skeleton

import and.degilevich.dream.shared.design.system.modifier.roundedThemeShimmer
import and.degilevich.dream.shared.design.system.modifier.themeShimmer
import and.degilevich.dream.shared.foundation.compose.ext.Space
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SkeletonSearchCard(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(all = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .themeShimmer()
                .size(40.dp),
        )
        Space(8.dp)
        Column {
            Spacer(
                modifier = Modifier
                    .roundedThemeShimmer()
                    .size(
                        width = 160.dp,
                        height = 16.dp
                    )
            )
            Space(4.dp)
            Spacer(
                modifier = Modifier
                    .roundedThemeShimmer()
                    .size(
                        width = 120.dp,
                        height = 12.dp
                    )
            )
        }
    }
}