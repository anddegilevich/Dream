package and.degilevich.dream.shared.app.api.component.children

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.common.component.dashboard.api.component.DashboardComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponent
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

    class ArtistDetails(
        component: ArtistDetailsComponent
    ) : Screen, ArtistDetailsComponent by component

    // Album
    class AlbumDetails(
        component: AlbumDetailsComponent
    ) : Screen, AlbumDetailsComponent by component

    // Track
    class TrackDetails(
        component: TrackDetailsComponent
    ) : Screen, TrackDetailsComponent by component

    // User
    class Profile(
        component: ProfileComponent
    ) : Screen, ProfileComponent by component
}