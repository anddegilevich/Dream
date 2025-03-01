package and.degilevich.dream.shared.foundation.decompose.navigator.ext

import and.degilevich.dream.shared.foundation.decompose.navigator.slot.SlotNavigationAction
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.dismiss

fun <SlotConfig : Any> SlotNavigation<in SlotConfig>.executeNavigationAction(
    action: SlotNavigationAction<SlotConfig>
) {
    when (action) {
        is SlotNavigationAction.Activate -> {
            activate(action.config)
        }

        is SlotNavigationAction.Dismiss -> {
            dismiss()
        }
    }
}