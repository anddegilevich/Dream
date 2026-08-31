package and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model

import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import kotlinx.serialization.Serializable

@Serializable
data class DrawerState(
    val user: UserData
)
