package and.degilevich.dream.shared.foundation.decompose.navigator.slot

abstract class SlotNavigatorAbs<SlotConfig : Any>(
    private val navigationActionHandler: SlotNavigationActionHandler<SlotConfig>
) : SlotNavigator<SlotConfig> {

    override fun navigate(action: SlotNavigationAction<SlotConfig>) {
        navigationActionHandler.handle(action)
    }

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