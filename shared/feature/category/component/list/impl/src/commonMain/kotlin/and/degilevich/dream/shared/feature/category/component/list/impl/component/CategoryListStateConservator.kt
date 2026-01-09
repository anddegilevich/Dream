package and.degilevich.dream.shared.feature.category.component.list.impl.component

import and.degilevich.dream.shared.feature.category.component.list.impl.component.model.CategoryListState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class CategoryListStateConservator : ComponentStateConservator<CategoryListState> {
    override val key: String = CategoryListState::class.className()
    override val initialState: CategoryListState = CategoryListState(
        isLoading = true,
        categories = emptyList(),
        categoryToColorMap = mapOf()
    )
    override val serializer: KSerializer<CategoryListState> = CategoryListState.serializer()
}