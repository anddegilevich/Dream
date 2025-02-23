package and.degilevich.dream.shared.foundation.decompose.navigator.slot

abstract class SlotNavigatorAbs<SlotConfig> : SlotNavigator<SlotConfig> {

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