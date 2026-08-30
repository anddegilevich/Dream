package and.degilevich.dream.shared.feature.common.component.drawer.api.component

import kotlinx.coroutines.flow.StateFlow

interface DrawerManager {

    val isOpened: StateFlow<Boolean>

    fun open()
    fun close()
}
