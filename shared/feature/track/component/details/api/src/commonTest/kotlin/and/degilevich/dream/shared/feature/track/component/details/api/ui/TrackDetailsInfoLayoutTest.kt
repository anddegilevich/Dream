package and.degilevich.dream.shared.feature.track.component.details.api.ui

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.track.component.details.api.ui.semantic.TrackDetailsInfoLayoutSemantic
import and.degilevich.dream.shared.feature.track.component.details.api.provider.TrackDetailsInfoLayoutUIDataPreviewProvider
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class TrackDetailsInfoLayoutTest {

    private val provider = TrackDetailsInfoLayoutUIDataPreviewProvider()
    private val name = hasTestTag(TrackDetailsInfoLayoutSemantic.TEST_TAG_NAME)

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                TrackDetailsInfoLayout(
                    data = provider.provideDefault()
                )
            }
        }
        onNode(name)
            .assertExists()
    }
}
