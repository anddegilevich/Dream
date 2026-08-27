package and.degilevich.dream.shared.core.webauth.impl.launcher

import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthResultReceiveChannel
import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthError
import and.degilevich.dream.shared.core.webauth.impl.model.WebAuthResult
import android.app.Application
import kotlinx.coroutines.CancellationException

internal class WebAuthLauncherImpl(
    private val application: Application,
    private val resultChannel: WebAuthResultReceiveChannel
) : WebAuthLauncher {

    override suspend fun authorize(url: String): Result<String> {
        return try {
            dropStaleResults()
            launchWebAuth(url = url)
            awaitRedirect()
        } catch (cancellation: CancellationException) {
            dismissWebAuth()
            throw cancellation
        } catch (error: Exception) {
            Result.failure(error)
        }
    }

    private suspend fun awaitRedirect(): Result<String> {
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

    private fun dismissWebAuth() {
        application.startActivity(
            WebAuthActivity.dismissIntent(context = application)
        )
    }
}
