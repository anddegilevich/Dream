package and.degilevich.dream.shared.feature.category.component.list.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.compose.modifier.skeleton.Skeleton
import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class CategoryListUIState(
    val categories: Skeleton<ImmutableList<CategoryCardUIData>>
) {

    companion object : EmptyFactory<CategoryListUIState> {

        override fun empty(): CategoryListUIState {
            return CategoryListUIState(
                categories = Skeleton.Loading
            )
        }
    }
}
