package and.degilevich.dream.shared.app.api.compose

import and.degilevich.dream.shared.app.api.component.RootComponent
import and.degilevich.dream.shared.foundation.decompose.compose.component.collectState
import and.degilevich.dream.shared.feature.artist.component.details.api.design.ArtistDetailsScreen
import and.degilevich.dream.shared.feature.artist.component.list.api.design.ArtistListScreen
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileIntent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.model.ProfileSideEffect
import and.degilevich.dream.shared.feature.user.component.profile.api.design.ProfileScreen
import and.degilevich.dream.shared.foundation.decompose.compose.animation.defaultStackAnimation
import and.degilevich.dream.shared.foundation.decompose.compose.component.ComponentSideEffect
import and.degilevich.dream.shared.foundation.filepicker.FilePicker
import and.degilevich.dream.shared.foundation.filepicker.state.FilePickerConfig
import and.degilevich.dream.shared.foundation.filepicker.state.rememberFilePickerState
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value

@Composable
fun DreamScreens(
    screens: Value<ChildStack<ScreenConfig, RootComponent.Child>>,
    modifier: Modifier = Modifier
) {
    Children(
        modifier = modifier.fillMaxSize(),
        stack = screens,
        animation = defaultStackAnimation()
    ) { screen ->
        val screenComponent = remember(screen.configuration) { screen.instance }

        when (screenComponent) {
            is RootComponent.Child.ArtistList -> {
                ArtistListScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
            }

            is RootComponent.Child.ArtistDetails -> {
                ArtistDetailsScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
            }

            is RootComponent.Child.Profile -> {

                val filePickerState = rememberFilePickerState()

                ProfileScreen(
                    state = screenComponent.collectState(),
                    onIntent = screenComponent::handleIntent
                )
                ComponentSideEffect(
                    component = screenComponent
                ) { sideEffect ->
                    when (sideEffect) {
                        ProfileSideEffect.OpenFilePicker -> {
                            filePickerState.launch(
                                FilePickerConfig(
                                    key = "profileIconKey",
                                    mimeTypes = setOf(
                                        "image/png",
                                        "image/jpeg",
                                        "image/jpg"
                                    )
                                )
                            )
                        }
                    }
                }

                FilePicker(
                    state = filePickerState,
                    onFilePicked = { pickedFile ->
                        screenComponent.handleIntent(
                            ProfileIntent.OnPhotoPicked(
                                pickedFile.url
                            )
                        )
                    }
                )
            }
        }
    }
}