package and.degilevich.dream.shared.app.api.component

import and.degilevich.dream.shared.core.toast.api.model.ToastData
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListComponent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.ProfileComponent
import and.degilevich.dream.shared.navigation.api.config.ScreenConfig
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.Flow

interface RootComponent {

    val screenStack: Value<ChildStack<ScreenConfig, Child>>

    // FIXME: Add drawer child component
    // https://arkivanov.github.io/Decompose/component/child-components/

    val toasts: Flow<ToastData>

    sealed interface Child {
        class ArtistList(
            component: ArtistListComponent
        ) : Child, ArtistListComponent by component

        class ArtistDetails(
            component: ArtistDetailsComponent
        ) : Child, ArtistDetailsComponent by component

        class Profile(
            component: ProfileComponent
        ) : Child, ProfileComponent by component
    }
}