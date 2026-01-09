package and.degilevich.dream.shared.feature.category.component.list.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class CategoryCardUIData(
    override val id: Identifier,
    val cardColor: Color,
    val name: String,
    val albumCoverUrl: String
) : Identified