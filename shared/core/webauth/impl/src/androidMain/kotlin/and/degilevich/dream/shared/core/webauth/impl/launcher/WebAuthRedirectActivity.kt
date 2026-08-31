package and.degilevich.dream.shared.core.webauth.impl.launcher

import and.degilevich.dream.shared.core.webauth.impl.channel.WebAuthResultSendChannel
import and.degilevich.dream.shared.core.webauth.impl.model.WebAuthResult
import android.app.Activity
import android.os.Bundle
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class WebAuthRedirectActivity : Activity(), KoinComponent {

    private val resultChannel: WebAuthResultSendChannel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.dataString?.let { url ->
            resultChannel.trySend(WebAuthResult.Redirect(url = url))
            startActivity(WebAuthActivity.dismissIntent(context = this))
        }
        finish()
    }
}
