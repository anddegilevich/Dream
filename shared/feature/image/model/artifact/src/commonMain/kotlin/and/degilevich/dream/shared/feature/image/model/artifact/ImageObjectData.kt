package and.degilevich.dream.shared.feature.image.model.artifact

import and.degilevich.dream.shared.foundation.model.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.model.empty.state.EmptyState

interface ImageObjectData : EmptyState {
    val url: String
    val height: String
    val width: String

    data class Base(
        override val url: String,
        override val height: String,
        override val width: String
    ) : ImageObjectData {
        override fun isEmpty(): Boolean {
            return url.isEmpty()
        }
    }

    companion object : EmptyFactory<ImageObjectData> {
        override fun empty(): ImageObjectData {
            return Base(
                url = "",
                height = "",
                width = ""
            )
        }
    }
}
