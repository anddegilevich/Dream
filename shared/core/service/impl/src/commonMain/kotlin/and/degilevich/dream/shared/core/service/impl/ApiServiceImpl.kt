package and.degilevich.dream.shared.core.service.impl

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.network.api.RemoteClient
import and.degilevich.dream.shared.core.service.api.ApiService
import and.degilevich.dream.shared.core.service.api.generated.api.AlbumsApi
import and.degilevich.dream.shared.core.service.api.generated.api.ArtistsApi
import and.degilevich.dream.shared.core.service.api.generated.api.SearchApi
import and.degilevich.dream.shared.core.service.api.generated.api.TracksApi
import and.degilevich.dream.shared.core.service.api.generated.api.UsersApi
import and.degilevich.dream.shared.core.service.api.model.SessionData
import and.degilevich.dream.shared.core.service.impl.session.storage.SessionStorage
import and.degilevich.dream.shared.core.service.impl.token.client.TokenService
import and.degilevich.dream.shared.core.service.impl.token.mappers.mapToBearer
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.bearer

internal class ApiServiceImpl(
    remoteClient: RemoteClient,
    private val sessionStorage: SessionStorage,
    private val tokenService: TokenService
) : ApiService {

    private val apiServiceClient = remoteClient.client.config {
        installDefaultRequest()
        installAuth()
    }

    private fun HttpClientConfig<*>.installDefaultRequest() {
        install(DefaultRequest) {
            url(SharedBuildConfig.API_BASE_URL)
        }
    }

    private fun HttpClientConfig<*>.installAuth() {
        install(Auth) {
            bearer {
                loadTokens {
                    sessionStorage.read()?.tokens?.mapToBearer()
                }
                refreshTokens {
                    tokenService.getToken().onSuccess { tokens ->
                        sessionStorage.save(SessionData(tokens = tokens))
                    }.getOrNull()?.mapToBearer()
                }
            }
        }
    }

    override val artistsApi: ArtistsApi by lazy {
        ArtistsApi(
            baseUrl = SharedBuildConfig.API_BASE_URL,
            httpClient = apiServiceClient
        )
    }

    override val albumsApi: AlbumsApi by lazy {
        AlbumsApi(
            baseUrl = SharedBuildConfig.API_BASE_URL,
            httpClient = apiServiceClient
        )
    }

    override val tracksApi: TracksApi by lazy {
        TracksApi(
            baseUrl = SharedBuildConfig.API_BASE_URL,
            httpClient = apiServiceClient
        )
    }

    override val searchApi: SearchApi by lazy {
        SearchApi(
            baseUrl = SharedBuildConfig.API_BASE_URL,
            httpClient = apiServiceClient
        )
    }

    override val usersApi: UsersApi by lazy {
        UsersApi(
            baseUrl = SharedBuildConfig.API_BASE_URL,
            httpClient = apiServiceClient
        )
    }
}