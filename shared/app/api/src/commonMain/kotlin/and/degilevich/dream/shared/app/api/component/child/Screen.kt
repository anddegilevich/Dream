package and.degilevich.dream.shared.app.api.component.child

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponent
import androidx.compose.runtime.Stable

@Stable
sealed interface Screen {

    // Common

    @Stable
    class Splash(
        component: SplashComponent
    ) : Screen, SplashComponent by component

    @Stable
    class Home(
        component: HomeComponent
    ) : Screen, HomeComponent by component

    // Artist

    @Stable
    class ArtistDetails(
        component: ArtistDetailsComponent
    ) : Screen, ArtistDetailsComponent by component

    // Album

    @Stable
    class AlbumDetails(
        component: AlbumDetailsComponent
    ) : Screen, AlbumDetailsComponent by component

    // Track

    @Stable
    class TrackDetails(
        component: TrackDetailsComponent
    ) : Screen, TrackDetailsComponent by component
}