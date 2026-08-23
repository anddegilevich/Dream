package and.degilevich.dream.shared.core.webauth.impl.launcher

import and.degilevich.dream.SharedBuildConfig
import and.degilevich.dream.shared.core.webauth.api.launcher.WebAuthLauncher
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthError
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import platform.AuthenticationServices.ASWebAuthenticationSession
import platform.AuthenticationServices.ASWebAuthenticationSessionErrorCodeCanceledLogin
import platform.Foundation.NSError
import platform.Foundation.NSURL
import kotlin.coroutines.resume

internal class WebAuthLauncherImpl : WebAuthLauncher {

    private val presentationContextProvider = WebAuthPresentationContextProvider()

    override suspend fun authorize(url: String): Result<String> = runCatching {
        withContext(Dispatchers.Main) {
            startSession(url = url)
        }
    }

    private suspend fun startSession(url: String): String {
        return suspendCancellableCoroutine { continuation ->
            val session = ASWebAuthenticationSession(
                uRL = NSURL(string = url),
                callbackURLScheme = CALLBACK_SCHEME,
                completionHandler = { callbackURL, error ->
                    continuation.resumeWithCallback(
                        callbackURL = callbackURL,
                        error = error
                    )
                }
            )
            session.presentationContextProvider = presentationContextProvider
            continuation.invokeOnCancellation {
                session.cancel()
            }
            session.start()
        }
    }

    private fun CancellableContinuation<String>.resumeWithCallback(
        callbackURL: NSURL?,
        error: NSError?
    ) {
        val redirect = callbackURL?.absoluteString
        when {
            redirect != null -> {
                resume(redirect)
            }

            error?.code == ASWebAuthenticationSessionErrorCodeCanceledLogin -> {
                resumeWith(Result.failure(WebAuthError.Cancelled()))
            }

            else -> {
                resumeWith(
                    Result.failure(
                        WebAuthError.Failed(
                            cause = error?.localizedDescription?.let(::Throwable)
                        )
                    )
                )
            }
        }
    }

    private companion object {
        val CALLBACK_SCHEME = SharedBuildConfig.REDIRECT_URI.substringBefore(delimiter = "://")
    }
}
