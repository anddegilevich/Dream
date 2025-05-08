package and.degilevich.dream.shared.app.api.component.children

import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.list.api.component.ArtistListComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.user.component.profile.api.componen.ProfileComponent

sealed interface Screen {

    // Common
    class Splash(
        component: SplashComponent
    ) : Screen, SplashComponent by component

    class Dashboard(
        component: DashboardComponent
    ) : Screen, DashboardComponent by component

    // Artist
    class ArtistList(
        component: ArtistListComponent
    ) : Screen, ArtistListComponent by component

    class ArtistDetails(
        component: ArtistDetailsComponent
    ) : Screen, ArtistDetailsComponent by component

    // User
    class Profile(
        component: ProfileComponent
    ) : Screen, ProfileComponent by component
}