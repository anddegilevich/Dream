package and.degilevich.dream.shared.core.webauth.impl.launcher

import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthResultReceiveChannel
import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthError
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthResult
import android.app.Application

internal class WebAuthLauncherImpl(
    private val application: Application,
    private val resultChannel: WebAuthResultReceiveChannel
) : WebAuthLauncher {

    override suspend fun authorize(url: String): Result<String> {
        dropStaleResults()
        launchWebAuth(url = url)
        return when (val result = resultChannel.receive()) {
            is WebAuthResult.Redirect -> {
                Result.success(result.url)
            }

            is WebAuthResult.Cancelled -> {
                Result.failure(WebAuthError.Cancelled())
            }
        }
    }

    private fun dropStaleResults() {
        do {
            val stale = resultChannel.tryReceive()
        } while (stale.isSuccess)
    }

    private fun launchWebAuth(url: String) {
        application.startActivity(
            WebAuthActivity.intent(
                context = application,
                url = url
            )
        )
    }
}
