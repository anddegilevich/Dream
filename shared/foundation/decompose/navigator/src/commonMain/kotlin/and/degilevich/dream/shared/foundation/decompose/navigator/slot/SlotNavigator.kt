package and.degilevich.dream.shared.foundation.decompose.navigator.slot

interface SlotNavigator<SlotConfig : Any> {
    fun navigate(action: SlotNavigationAction<SlotConfig>)
    fun dismiss()
    fun activate(config: SlotConfig)
}