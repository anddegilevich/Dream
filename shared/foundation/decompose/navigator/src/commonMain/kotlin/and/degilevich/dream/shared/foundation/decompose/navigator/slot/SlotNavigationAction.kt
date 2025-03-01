package and.degilevich.dream.shared.foundation.decompose.navigator.slot

sealed interface SlotNavigationAction<in SlotConfig : Any> {
    class Dismiss<in SlotConfig : Any> : SlotNavigationAction<SlotConfig>
    data class Activate<SlotConfig : Any>(
        val config: SlotConfig
    ) : SlotNavigationAction<SlotConfig>
}