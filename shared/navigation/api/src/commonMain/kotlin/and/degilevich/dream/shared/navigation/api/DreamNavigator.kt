package and.degilevich.dream.shared.navigation.api

import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import and.degilevich.dream.shared.foundation.decompose.navigation.result.NavigationResultManager
import com.arkivanov.decompose.router.stack.StackNavigator

interface DreamNavigator {
    val screenNavigator: StackNavigator<ScreenConfig>
    val resultManager: NavigationResultManager
    // FIXME: Implement later
//    val bottomSheetNavigator: SlotNavigator<BottomSheetConfig>
//    val dialogNavigator: SlotNavigator<DialogConfig>
}