package and.degilevich.dream.shared.foundation.decompose.navigator.slot

interface SlotNavigationActionHandler<out SlotConfig : Any> {
    fun handle(action: SlotNavigationAction<SlotConfig>)
}