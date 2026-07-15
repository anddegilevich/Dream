package and.degilevich.dream.shared.core.service.api

import and.degilevich.dream.shared.core.service.api.generated.api.AlbumsApi
import and.degilevich.dream.shared.core.service.api.generated.api.ArtistsApi
import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.core.service.api.generated.api.TracksApi

@Suppress("TooManyFunctions")
interface ApiService {
    val artistsApi: ArtistsApi
    val albumsApi: AlbumsApi
    val tracksApi: TracksApi
    val searchApi: SearchApi
}