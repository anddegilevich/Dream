package and.degilevich.dream.shared.feature.category.model.core.api.data

import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageObjectData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import and.degilevich.dream.shared.foundation.abstraction.id.Identifier
import kotlinx.serialization.Serializable

@Serializable
data class CategoryData(
    override val id: Identifier,
    val name: String,
    val icons: List<ImageObjectData>
) : AbstractIdentified() {

    companion object : EmptyFactory<CategoryData> {

        override fun empty(): CategoryData {
            return CategoryData(
                id = Identifier.empty(),
                name = "",
                icons = emptyList()
            )
        }
    }
}
