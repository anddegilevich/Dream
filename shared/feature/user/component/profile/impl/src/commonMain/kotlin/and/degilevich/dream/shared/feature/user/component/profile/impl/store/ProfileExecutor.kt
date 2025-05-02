package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.core.filepicker.api.FilePickerManager
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.ExecutorAbs
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerRequest
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerResult
import and.degilevich.dream.shared.foundation.filepicker.model.FilePickerSource
import and.degilevich.dream.shared.navigation.api.AppNavigator
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

    private val navigator: AppNavigator by inject()
    private val filePickerManager: FilePickerManager by inject()

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
            is ProfileIntent.OnIconClicked -> openProfileIconImagePicker()
            is ProfileIntent.OnAddPhotoClicked -> openProfilePhotosImagePicker()
        }
    }

    private fun collectFilePickerResult() {
        collectFilePickerResultJob?.cancel()
        collectFilePickerResultJob = scope.launch {
            filePickerManager.subscribeToResult { result ->
                handleFilePickerResult(result)
            }
        }
    }

    private fun handleFilePickerResult(result: FilePickerResult) {
        when (result.key) {
            PROFILE_ICON_FILE_PICKER_KEY -> {
                val uri = result.uris.firstOrNull() ?: return
                setIconUri(uri)
            }

            PROFILE_PHOTOS_FILE_PICKER_KEY -> {
                setPhotosUris(result.uris)
            }
        }
    }

    private fun openProfileIconImagePicker() {
        val request = FilePickerRequest(
            key = PROFILE_ICON_FILE_PICKER_KEY,
            isMultiselect = false,
            source = FilePickerSource.GALLERY
        )
        scope.launch {
            filePickerManager.openFilePicker(request)
        }
    }

    private fun openProfilePhotosImagePicker() {
        val request = FilePickerRequest(
            key = PROFILE_PHOTOS_FILE_PICKER_KEY,
            isMultiselect = true,
            source = FilePickerSource.FILES,
            mimeTypes = setOf(
                "image/png",
                "image/jpeg",
                "image/jpg"
            )
        )
        scope.launch {
            filePickerManager.openFilePicker(request)
        }
    }

    private fun setIconUri(uri: String) {
        reduce {
            copy(
                iconUri = uri
            )
        }
    }

    private fun setPhotosUris(uris: List<String>) {
        reduce {
            copy(profilePhotosUris = uris)
        }
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }

    private companion object {
        const val PROFILE_ICON_FILE_PICKER_KEY = "profileIconKey"
        const val PROFILE_PHOTOS_FILE_PICKER_KEY = "profilePhotosKey"
    }
}