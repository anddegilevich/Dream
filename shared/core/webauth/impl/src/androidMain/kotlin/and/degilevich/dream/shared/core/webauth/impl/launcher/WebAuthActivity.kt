package and.degilevich.dream.shared.core.webauth.impl.launcher

import and.degilevich.dream.shared.core.webauth.api.channel.WebAuthResultSendChannel
import and.degilevich.dream.shared.core.webauth.api.model.WebAuthResult
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

internal class WebAuthActivity : Activity(), KoinComponent {

    private val resultChannel: WebAuthResultSendChannel by inject()

    private var isCustomTabLaunched: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isCustomTabLaunched = savedInstanceState?.getBoolean(KEY_IS_CUSTOM_TAB_LAUNCHED) == true
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        finish()
    }

    override fun onResume() {
        super.onResume()
        when {
            isFinishing -> Unit
            isCustomTabLaunched -> reportCancelled()
            else -> launchCustomTab()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_IS_CUSTOM_TAB_LAUNCHED, isCustomTabLaunched)
    }

    private fun launchCustomTab() {
        val url = intent.getStringExtra(EXTRA_URL)
        if (url == null) {
            finish()
            return
        }
        isCustomTabLaunched = true
        CustomTabsIntent.Builder()
            .build()
            .launchUrl(this, url.toUri())
    }

    private fun reportCancelled() {
        resultChannel.trySend(WebAuthResult.Cancelled)
        finish()
    }

    companion object {

        private const val EXTRA_URL = "web_auth_url"
        private const val KEY_IS_CUSTOM_TAB_LAUNCHED = "is_custom_tab_launched"

        fun intent(
            context: Context,
            url: String
        ): Intent {
            return Intent(context, WebAuthActivity::class.java)
                .putExtra(EXTRA_URL, url)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        fun dismissIntent(context: Context): Intent {
            return Intent(context, WebAuthActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
        }
    }
}
