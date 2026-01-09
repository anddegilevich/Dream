package and.degilevich.dream.shared.feature.category.component.list.api.design

import and.degilevich.dream.Res
import and.degilevich.dream.shared.design.theme.api.Theme
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListIntent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.feature.category.component.list.api.design.skeleton.SkeletonCategoryCard
import and.degilevich.dream.shared.foundation.compose.ext.Space
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.identifiedSkeletonItems
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource

@Composable
fun CategoryListCarousel(
    state: CategoryListUIState,
    modifier: Modifier = Modifier,
    onIntent: (CategoryListIntent) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(Res.strings.title_categories),
            color = Theme.colors.text.primary,
            style = Theme.typography.h1
        )
        Space(8.dp)
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            identifiedSkeletonItems(
                skeleton = state.categories,
                loadingItemsCount = 5,
                loadingItemContent = {
                    SkeletonCategoryCard()
                },
                itemContent = { album ->
                    CategoryCard(
                        modifier = Modifier.animateItem(),
                        data = album
                    ) { id ->
                        onIntent(
                            CategoryListIntent.OnCategoryClicked(id = id)
                        )
                    }
                }
            )
        }
    }
}