package and.degilevich.dream.shared.app.api.component.children

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListComponent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.ProfileComponent

sealed interface Screen {
    class ArtistList(
        component: ArtistListComponent
    ) : Screen, ArtistListComponent by component

    class ArtistDetails(
        component: ArtistDetailsComponent
    ) : Screen, ArtistDetailsComponent by component

    class Profile(
        component: ProfileComponent
    ) : Screen, ProfileComponent by component
}