package and.degilevich.dream.shared.feature.common.component.splash.impl.component

import and.degilevich.dream.shared.feature.common.component.splash.api.component.model.SplashUIState
import and.degilevich.dream.shared.feature.common.component.splash.impl.store.model.SplashState
import and.degilevich.dream.shared.foundation.abstraction.mapper.Mapper

internal class SplashUIStateMapper : Mapper<SplashState, SplashUIState> {
    override fun map(item: SplashState): SplashUIState {
        return SplashUIState()
    }
}