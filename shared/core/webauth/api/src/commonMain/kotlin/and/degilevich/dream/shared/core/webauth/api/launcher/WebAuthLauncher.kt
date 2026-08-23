package and.degilevich.dream.shared.core.webauth.api.launcher

interface WebAuthLauncher {
    suspend fun authorize(url: String): Result<String>
}
