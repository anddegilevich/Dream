package and.degilevich.dream.shared.feature.image.model.artifact.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class ImageObjectData(
    val url: String,
    val height: String,
    val width: String
) : EmptyState {

    override fun isEmpty(): Boolean {
        return url.isEmpty()
    }

    companion object : EmptyFactory<ImageObjectData> {
        override fun empty(): ImageObjectData {
            return ImageObjectData(
                url = "",
                height = "",
                width = ""
            )
        }
    }
}
