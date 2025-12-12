package and.degilevich.dream.shared.foundation.compose.preview

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Day",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    group = "uiMode"
)
@Preview(
    name = "Night",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    group = "uiMode"
)
annotation class DayNightPreviews