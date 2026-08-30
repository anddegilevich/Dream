package and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import kotlinx.serialization.Serializable

@Serializable
data class TopbarState(
    val isLoading: Boolean,
    val user: UserData
)
