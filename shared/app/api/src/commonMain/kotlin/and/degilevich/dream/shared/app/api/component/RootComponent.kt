package and.degilevich.dream.shared.app.api.component

import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow

interface RootComponent {

    val screenStack: Value<ChildStack<ScreenConfig, Screen>>
    val navbar: NavbarComponent
    val toasts: Flow<ToastData>
    val filePickerRequests: Flow<FilePickerRequest>

    fun handleFilePickerResult(result: FilePickerResult)
}