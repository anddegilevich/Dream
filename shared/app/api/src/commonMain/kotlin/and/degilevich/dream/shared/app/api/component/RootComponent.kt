package and.degilevich.dream.shared.app.api.component

import and.degilevich.dream.shared.app.api.component.children.Navbar
import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.navigation.api.model.config.NavbarConfig
import and.degilevich.dream.shared.navigation.api.model.config.ScreenConfig
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow

interface RootComponent {

    val screenStack: Value<ChildStack<ScreenConfig, Screen>>
    val navbar: Value<ChildSlot<NavbarConfig, Navbar>>
    val toasts: Flow<ToastData>
    val filePickerRequests: Flow<FilePickerRequest>

    fun handleFilePickerResult(result: FilePickerResult)
}