package and.degilevich.dream.shared.feature.category.component.list.impl.component.model

import and.degilevich.dream.shared.feature.category.model.core.api.data.CategoryData
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import and.degilevich.dream.shared.resource.api.pallet.PalletColor
import kotlinx.serialization.Serializable

@Serializable
data class CategoryListState(
    val isLoading: Boolean,
    val categories: List<CategoryData>,
    val categoryToColorMap: Map<Identifier, PalletColor>
)
