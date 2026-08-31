package and.degilevich.dream.shared.feature.user.data.mapper.test.remote

import and.degilevich.dream.shared.core.service.api.generated.model.PrivateUserObject
import and.degilevich.dream.shared.feature.user.data.mapper.api.remote.UserOutputToDataMapper
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeUserOutputToDataMapper(
    private val onMap: (PrivateUserObject) -> UserData = { fakeImplementationError() }
) : UserOutputToDataMapper {

    override fun map(item: PrivateUserObject): UserData = onMap(item)
}
