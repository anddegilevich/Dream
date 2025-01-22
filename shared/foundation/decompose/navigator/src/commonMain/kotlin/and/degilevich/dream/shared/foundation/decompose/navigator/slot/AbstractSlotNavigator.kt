package and.degilevich.dream.shared.foundation.decompose.navigator.slot

abstract class AbstractSlotNavigator<SlotConfig> : SlotNavigator<SlotConfig> {

    override fun activate(config: SlotConfig) {
        navigate(
            SlotNavigationAction.Activate(config = config)
        )
    }

    override fun dismiss() {
        navigate(
            SlotNavigationAction.Dismiss()
        )
    }
}