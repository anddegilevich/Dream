package and.degilevich.dream.shared.feature.common.component.drawer.impl.component

import and.degilevich.dream.shared.feature.common.component.drawer.api.component.DrawerManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal class DrawerManagerImpl : DrawerManager {

    private val mutableIsOpened = MutableStateFlow(false)

    override val isOpened = mutableIsOpened.asStateFlow()

    override fun open() {
        mutableIsOpened.update { true }
    }

    override fun close() {
        mutableIsOpened.update { false }
    }
}
