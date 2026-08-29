package and.degilevich.dream.shared.feature.user.domain.test.manager

import and.degilevich.dream.shared.feature.user.domain.api.manager.UserFetchingManager
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeUserFetchingManager(
    private val onFetch: suspend () -> Result<UserData> = { fakeImplementationError() }
) : UserFetchingManager {

    override suspend fun fetch(): Result<UserData> = onFetch()
}
