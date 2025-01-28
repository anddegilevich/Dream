package and.degilevich.dream.shared.navigation.api.dream.navigator

import and.degilevich.dream.shared.navigation.api.dream.config.ScreenConfig
import and.degilevich.dream.shared.foundation.decompose.navigator.stack.StackNavigator
import and.degilevich.dream.shared.foundation.decompose.navigator.result.NavigationResultManager

interface DreamNavigator {
    val screenNavigator: StackNavigator<ScreenConfig>
    val resultManager: NavigationResultManager
    // FIXME: Implement later
//    val bottomSheetNavigator: SlotNavigator<BottomSheetConfig>
//    val dialogNavigator: SlotNavigator<DialogConfig>
}