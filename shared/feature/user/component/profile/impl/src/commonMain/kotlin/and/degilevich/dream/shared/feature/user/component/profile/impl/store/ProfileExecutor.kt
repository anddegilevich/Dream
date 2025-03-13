package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.core.filepicker.api.FilePickerRequestChannel
import and.degilevich.dream.shared.core.filepicker.api.FilePickerResultChannel
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.ExecutorAbs
import and.degilevich.dream.shared.foundation.dispatcher.ext.flow.flowOnBackground
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.navigation.api.DreamNavigator
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.doOnStart
import com.arkivanov.essenty.lifecycle.doOnStop
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ProfileExecutor(
    lifecycle: Lifecycle
) : ExecutorAbs<ProfileState, ProfileIntent, ProfileSideEffect>(lifecycle = lifecycle), KoinComponent {

    private val navigator: DreamNavigator by inject()
    private val filePickerRequestChannel: FilePickerRequestChannel by inject()
    private val filePickerResultChannel: FilePickerResultChannel by inject()

    init {
        subscribeToLifecycle()
    }

    private var collectFilePickerResultJob: Job? = null

    private fun subscribeToLifecycle() {
        doOnStart {
            collectFilePickerResult()
        }
        doOnStop {
            collectFilePickerResultJob?.cancel()
        }
    }

    override fun executeIntent(intent: ProfileIntent) {
        when (intent) {
            is ProfileIntent.OnBackClicked -> navigateBack()
            is ProfileIntent.OnIconClicked -> openImagePicker()
        }
    }

    private fun collectFilePickerResult() {
        collectFilePickerResultJob?.cancel()
        collectFilePickerResultJob = scope.launch {
            filePickerResultChannel.value.flowOnBackground().collect { result ->
                handleFilePickerResult(result)
            }
        }
    }

    private fun handleFilePickerResult(result: FilePickerResult) {
        if (result.key != PROFILE_ICON_FILE_PICKER_KEY) return
        val uri = result.uris.firstOrNull() ?: return
        setIconUri(uri)
    }

    private fun setIconUri(uri: String) {
        reduce { state ->
            state.copy(
                iconUri = uri
            )
        }
    }

    private fun openImagePicker() {
        val request = FilePickerRequest(
            key = PROFILE_ICON_FILE_PICKER_KEY,
            isMultiselect = false,
            mimeTypes = setOf(
                "image/png",
                "image/jpeg",
                "image/jpg"
            )
        )
        scope.launch {
            filePickerRequestChannel.send(request)
        }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private companion object {
        const val PROFILE_ICON_FILE_PICKER_KEY = "profileIconKey"
    }
}