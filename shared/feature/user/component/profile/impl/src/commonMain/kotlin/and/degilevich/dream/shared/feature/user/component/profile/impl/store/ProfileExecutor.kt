package and.degilevich.dream.shared.feature.user.component.profile.impl.store

import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.impl.store.model.ProfileState
import and.degilevich.dream.shared.foundation.decompose.component.store.executor.ExecutorAbs
import and.degilevich.dream.shared.navigation.api.DreamNavigator
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.essenty.lifecycle.Lifecycle
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class ProfileExecutor(
    lifecycle: Lifecycle
) : ExecutorAbs<ProfileState, ProfileIntent, ProfileSideEffect>(lifecycle = lifecycle), KoinComponent {

    private val navigator: DreamNavigator by inject()

    override fun executeIntent(intent: ProfileIntent) {
        when (intent) {
            is ProfileIntent.OnBackClicked -> navigateBack()
            is ProfileIntent.OnIconClicked -> openImagePicker()
            is ProfileIntent.OnPhotoPicked -> onPhotoPicked(intent)
        }
    }

    private fun onPhotoPicked(intent: ProfileIntent.OnPhotoPicked) {
        setIconUrl(intent.path)
    }

    private fun setIconUrl(path: String) {
        reduce { state ->
            state.copy(
                iconUrl = path
            )
        }
    }

    private fun openImagePicker() {
        publish(ProfileSideEffect.OpenFilePicker)
    }

    private fun navigateBack() {
        navigator.screenNavigator.pop()
    }
}