package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.common.component.splash.impl.component.model.SplashState
import and.degilevich.dream.shared.foundation.decompose.component.mvi.conservator.ComponentStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class SplashStateConservator : ComponentStateConservator<SplashState> {
    override val key: String = SplashState::class.className()
    override val initialState: SplashState = SplashState()
    override val serializer: KSerializer<SplashState> = SplashState.serializer()
}