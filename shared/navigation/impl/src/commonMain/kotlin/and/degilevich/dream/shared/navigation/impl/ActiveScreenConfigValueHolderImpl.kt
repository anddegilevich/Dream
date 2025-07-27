package and.degilevich.dream.shared.navigation.impl

import and.degilevich.dream.shared.foundation.abstraction.holder.AbstractMutableValueHolder
import and.degilevich.dream.shared.navigation.api.ActiveScreenConfigValueHolder
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig

internal class ActiveScreenConfigValueHolderImpl :
    AbstractMutableValueHolder<ScreenConfig>(
        initialValue = ScreenConfig.Splash
    ),
    ActiveScreenConfigValueHolder