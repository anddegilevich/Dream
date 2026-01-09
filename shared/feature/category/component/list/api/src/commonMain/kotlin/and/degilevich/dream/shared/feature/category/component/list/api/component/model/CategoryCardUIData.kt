package and.degilevich.dream.shared.feature.category.component.list.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Immutable

@Immutable
data class CategoryCardUIData(
    override val id: Identifier
) : Identified