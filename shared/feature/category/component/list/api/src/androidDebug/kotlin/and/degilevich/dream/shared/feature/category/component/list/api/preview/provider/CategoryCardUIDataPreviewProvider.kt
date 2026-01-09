package and.degilevich.dream.shared.feature.category.component.list.api.preview.provider

import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryCardUIData
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Suppress("MagicNumber")
class CategoryCardUIDataPreviewProvider : PreviewParameterProvider<CategoryCardUIData> {

    override val values: Sequence<CategoryCardUIData> = sequenceOf(provide())

    fun provide(): CategoryCardUIData {
        return CategoryCardUIData(
            id = Identifier("pop"),
            cardColor = Color(0xFF9854B2),
            name = "Pop",
            albumCoverUrl = ""
        )
    }

    fun provideList(): ImmutableList<CategoryCardUIData> {
        return persistentListOf(
            CategoryCardUIData(
                id = Identifier("pop"),
                cardColor = Color(0xFF9854B2),
                name = "Pop",
                albumCoverUrl = ""
            ),
            CategoryCardUIData(
                id = Identifier("rock"),
                cardColor = Color(0xFF678026),
                name = "Rock",
                albumCoverUrl = ""
            ),
            CategoryCardUIData(
                id = Identifier("rap"),
                cardColor = Color(0xFFCF4321),
                name = "Rap",
                albumCoverUrl = ""
            ),

        )
    }
}