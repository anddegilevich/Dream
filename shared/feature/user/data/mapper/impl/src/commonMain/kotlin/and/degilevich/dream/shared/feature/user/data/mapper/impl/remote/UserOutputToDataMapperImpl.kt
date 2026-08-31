package and.degilevich.dream.shared.feature.user.data.mapper.impl.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PrivateUserObject
import and.degilevich.dream.shared.feature.image.data.mapper.api.remote.ImageOutputToDataMapper
import and.degilevich.dream.shared.feature.user.data.mapper.api.remote.UserOutputToDataMapper
import and.degilevich.dream.shared.feature.user.model.artifact.api.data.UserId
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.abstraction.empty.factory.ext.orEmpty
import and.degilevich.dream.shared.foundation.abstraction.mapper.ext.mapWith

internal class UserOutputToDataMapperImpl(
    private val imageOutputToDataMapper: ImageOutputToDataMapper
) : UserOutputToDataMapper {

    override fun map(item: PrivateUserObject): UserData = with(item) {
        UserData(
            id = id?.let(::UserId).orEmpty(UserId),
            displayName = displayName.orEmpty(),
            images = images?.mapWith(imageOutputToDataMapper).orEmpty()
        )
    }
}
