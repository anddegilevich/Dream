package and.degilevich.dream.shared.app.api.component

import and.degilevich.dream.shared.app.api.component.children.Screen
import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow

interface RootComponent {

    val screenStack: Value<ChildStack<ScreenConfig, Screen>>

    // FIXME: Add drawer child component
    // https://arkivanov.github.io/Decompose/component/child-components/

    val toasts: Flow<ToastData>
    val filePickerRequests: Flow<FilePickerRequest>

    fun handleFilePickerResult(result: FilePickerResult)
}