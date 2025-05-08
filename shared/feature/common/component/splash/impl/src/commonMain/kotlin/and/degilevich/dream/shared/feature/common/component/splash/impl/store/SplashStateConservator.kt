package and.degilevich.dream.shared.feature.common.component.splash.impl.store

import and.degilevich.dream.shared.feature.common.component.splash.impl.store.model.SplashState
import and.degilevich.dream.shared.foundation.decompose.component.store.conservator.StoreStateConservator
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import kotlinx.serialization.KSerializer

internal class SplashStateConservator : StoreStateConservator<SplashState> {
    override val key: String = SplashState::class.className()
    override val initialState: SplashState = SplashState()
    override val serializer: KSerializer<SplashState> = SplashState.serializer()
}