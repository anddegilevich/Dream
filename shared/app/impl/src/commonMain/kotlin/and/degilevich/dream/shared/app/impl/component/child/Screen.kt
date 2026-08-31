package and.degilevich.dream.shared.app.impl.component.child

import and.degilevich.dream.shared.feature.album.component.details.api.component.AlbumDetailsComponent
import and.degilevich.dream.shared.feature.artist.component.details.api.component.ArtistDetailsComponent
import and.degilevich.dream.shared.feature.auth.component.login.api.component.LoginComponent
import and.degilevich.dream.shared.feature.common.component.splash.api.component.SplashComponent
import and.degilevich.dream.shared.feature.common.home.api.component.HomeComponent
import and.degilevich.dream.shared.feature.track.component.details.api.component.TrackDetailsComponent
import and.degilevich.dream.shared.feature.track.component.liked.api.component.LikedTracksComponent
import and.degilevich.dream.shared.foundation.decompose.component.render.RenderComponent
import androidx.compose.runtime.Stable

@Stable
internal sealed interface Screen : RenderComponent {

    // Common

    @Stable
    class Splash(
        component: SplashComponent
    ) : Screen, SplashComponent by component

    @Stable
    class Home(
        component: HomeComponent
    ) : Screen, HomeComponent by component

    // Auth

    @Stable
    class Login(
        component: LoginComponent
    ) : Screen, LoginComponent by component

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

    @Stable
    class LikedTracks(
        component: LikedTracksComponent
    ) : Screen, LikedTracksComponent by component
}
