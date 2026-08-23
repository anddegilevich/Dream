package and.degilevich.dream.shared.core.webauth.impl.launcher

import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthRedirectReceiveChannel
import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthError
import android.app.Application
import android.content.Intent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

internal class WebAuthLauncherImpl(
    private val application: Application,
    private val redirectChannel: WebAuthRedirectReceiveChannel
) : WebAuthLauncher {

    override suspend fun authorize(url: String): Result<String> = runCatching {
        dropStaleRedirect()
        coroutineScope {
            val redirect = CompletableDeferred<String>()
            val redirectJob = launch {
                redirect.complete(redirectChannel.receive())
            }
            val returnToAppCallbacks = ReturnToAppCallbacks(
                onReturned = {
                    redirect.completeExceptionally(WebAuthError.Cancelled())
                }
            )
            application.registerActivityLifecycleCallbacks(returnToAppCallbacks)
            try {
                launchCustomTab(url = url)
                redirect.await()
            } finally {
                application.unregisterActivityLifecycleCallbacks(returnToAppCallbacks)
                redirectJob.cancel()
            }
        }
    }

    private fun dropStaleRedirect() {
        do {
            val stale = redirectChannel.tryReceive()
        } while (stale.isSuccess)
    }

    private fun launchCustomTab(url: String) {
        CustomTabsIntent.Builder()
            .build()
            .apply {
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            .launchUrl(application, url.toUri())
    }
}
