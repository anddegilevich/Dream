package and.degilevich.dream.shared.core.service.api

import and.degilevich.dream.shared.core.service.api.generated.api.AlbumsApi
import and.degilevich.dream.shared.core.service.api.generated.api.ArtistsApi
import and.degilevich.dream.shared.core.service.api.generated.api.PlayerApi
import and.degilevich.dream.shared.core.service.api.generated.api.PlaylistsApi
import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.core.service.api.generated.api.TracksApi
import and.degilevich.dream.shared.core.service.api.generated.api.UsersApi

interface ApiService {
    val artistsApi: ArtistsApi
    val albumsApi: AlbumsApi
    val tracksApi: TracksApi
    val searchApi: SearchApi
    val usersApi: UsersApi
    val playlistsApi: PlaylistsApi
    val playerApi: PlayerApi
}
