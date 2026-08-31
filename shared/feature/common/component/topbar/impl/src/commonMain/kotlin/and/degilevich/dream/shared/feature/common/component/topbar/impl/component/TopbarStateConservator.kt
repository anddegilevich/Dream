package and.degilevich.dream.shared.feature.common.component.topbar.impl.component

import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarState
import and.degilevich.dream.shared.feature.user.model.core.api.data.UserData
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class TopbarStateConservator : ComponentStateConservator<TopbarState> {
    override val key: String = TopbarState::class.className()
    override val initialState: TopbarState = TopbarState(
        user = UserData.empty()
    )
    override val serializer: KSerializer<TopbarState> = TopbarState.serializer()
}
