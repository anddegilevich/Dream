package and.degilevich.dream.shared.foundation.compose.preview

import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.AndroidUiModes.UI_MODE_TYPE_NORMAL
import androidx.compose.ui.tooling.preview.Preview

// FIXME: Remove when androidx.compose.ui.tooling.preview.PreviewLightDark is fixed for CMP preview
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.FUNCTION)
@Preview(name = "Light")
@Preview(name = "Dark", uiMode = UI_MODE_NIGHT_YES or UI_MODE_TYPE_NORMAL)
annotation class LightDarkPreviews