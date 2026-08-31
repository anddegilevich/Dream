package and.degilevich.dream.shared.feature.user.domain.api.manager

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData

interface UserFetchingManager {
    suspend fun fetch(): Result<UserData>
}
