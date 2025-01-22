package and.degilevich.dream.shared.foundation.decompose.navigator.slot

sealed interface SlotNavigationAction<SlotConfig> {
    class Dismiss<SlotConfig> : SlotNavigationAction<SlotConfig>
    data class Activate<SlotConfig>(
        val config: SlotConfig
    ) : SlotNavigationAction<SlotConfig>
}