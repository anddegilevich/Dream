package and.degilevich.dream.shared.feature.album.component.details.api.design

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.album.component.details.api.design.semantic.AlbumDetailsLayoutSemantic
import and.degilevich.dream.shared.feature.album.component.details.api.provider.AlbumDetailsLayoutUIDataPreviewProvider
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AlbumDetailsLayoutTest {

    private val provider = AlbumDetailsLayoutUIDataPreviewProvider()
    private val name = hasTestTag(AlbumDetailsLayoutSemantic.TEST_TAG_NAME)

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                AlbumDetailsLayout(data = provider.provideDefault())
            }
        }
        onNode(name)
            .assertExists()
            .assertIsDisplayed()
    }
}
