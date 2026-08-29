package and.degilevich.dream.shared.feature.user.data.impl.storage

import and.degilevich.dream.shared.feature.base.data.impl.storage.BaseStorage
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData

internal class UserDataStorageImpl :
    BaseStorage<UserData>(
        key = USER_DATA_STORAGE_KEY,
        serializer = UserData.serializer()
    ),
    UserDataStorage

private const val USER_DATA_STORAGE_KEY = "user"
