package and.degilevich.dream.shared.feature.common.component.splash.api.component.model

import and.degilevich.dream.shared.foundation.abstraction.empty.factory.EmptyFactory
import androidx.compose.runtime.Immutable

@Immutable
class SplashUIState {
    companion object : EmptyFactory<SplashUIState> {
        override fun empty(): SplashUIState {
            return SplashUIState()
        }
    }
}
