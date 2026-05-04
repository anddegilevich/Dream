package and.degilevich.dream.shared.feature.artist.component.details.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.artist.component.details.api.design.semantic.ArtistInfoLayoutSemantic
import and.degilevich.dream.shared.feature.artist.component.details.api.provider.ArtistInfoLayoutUIDataPreviewProvider
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class ArtistInfoLayoutTest {

    private val provider = ArtistInfoLayoutUIDataPreviewProvider()
    private val name = hasTestTag(ArtistInfoLayoutSemantic.TEST_TAG_NAME)

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                ArtistInfoLayout(data = provider.provide())
            }
        }
        onNode(name)
            .assertExists()
            .assertIsDisplayed()
    }
}
