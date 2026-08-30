package and.degilevich.dream.shared.feature.common.component.drawer.impl.component

import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerState
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class DrawerStateConservator : ComponentStateConservator<DrawerState> {
    override val key: String = DrawerState::class.className()
    override val initialState: DrawerState = DrawerState(
        user = UserData.empty()
    )
    override val serializer: KSerializer<DrawerState> = DrawerState.serializer()
}
