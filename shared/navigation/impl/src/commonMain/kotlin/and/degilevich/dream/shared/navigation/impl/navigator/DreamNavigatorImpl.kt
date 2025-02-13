package and.degilevich.dream.shared.navigation.impl.navigator

import and.degilevich.dream.shared.navigation.api.dream.navigator.DreamNavigator
import and.degilevich.dream.shared.navigation.impl.result.DreamNavigationResultManager

internal class DreamNavigatorImpl(
    override val screenNavigator: ScreenNavigator,
    override val resultManager: DreamNavigationResultManager
) : DreamNavigator