package and.degilevich.dream.shared.feature.category.component.list.impl.component

import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryCardUIData
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.feature.category.component.list.impl.component.model.CategoryListState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import and.degilevich.dream.shared.resource.api.pallet.PalletColor
import and.degilevich.dream.shared.resource.api.pallet.PalletManager
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class CategoryListUIStateMapper : Mapper<CategoryListState, CategoryListUIState>, KoinComponent {

    private val palletManager: PalletManager by inject()

    override fun map(item: CategoryListState): CategoryListUIState {
        return CategoryListUIState(
            categories = mapToCategories(state = item)
        )
    }

    private fun mapToCategories(state: CategoryListState): Skeleton<ImmutableList<CategoryCardUIData>> = with(state) {
        if (categories.isEmpty()) {
            Skeleton.Loading
        } else {
            Skeleton.Value(
                value = categories
                    .map { category ->
                        CategoryCardUIData(
                            id = category.id,
                            cardColor = palletManager.getColor(
                                color = categoryToColorMap.get(category.id) ?: PalletColor.UNDEFINED
                            ),
                            name = category.name,
                            albumCoverUrl = category.icons.firstOrNull()?.url.orEmpty()
                        )
                    }
                    .toImmutableList()
            )
        }
    }
}