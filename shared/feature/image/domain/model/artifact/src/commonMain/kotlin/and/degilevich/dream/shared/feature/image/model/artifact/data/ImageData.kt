package and.degilevich.dream.shared.feature.image.model.artifact.data

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.empty.state.EmptyState
import kotlinx.serialization.Serializable

@Serializable
data class ImageData(
    val url: String,
    val height: Int,
    val width: Int
) : EmptyState {

    override fun isEmpty(): Boolean {
        return url.isEmpty()
    }

    companion object : EmptyFactory<ImageData> {
        override fun empty(): ImageData {
            return ImageData(
                url = "",
                height = 0,
                width = 0
            )
        }
    }
}
