package and.degilevich.dream.shared.feature.user.model.core.api.data

import and.degilevich.dream.shared.feature.image.model.artifact.api.data.ImageData
import and.degilevich.dream.shared.feature.user.model.artifact.api.data.UserId
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import and.degilevich.dream.shared.foundation.abstraction.id.AbstractIdentified
import kotlinx.serialization.Serializable

@Serializable
data class UserData(
    override val id: UserId,
    val displayName: String,
    val images: List<ImageData>
) : AbstractIdentified() {

    companion object : EmptyFactory<UserData> {

        override fun empty(): UserData {
            return UserData(
                id = UserId.empty(),
                displayName = "",
                images = emptyList()
            )
        }
    }
}
