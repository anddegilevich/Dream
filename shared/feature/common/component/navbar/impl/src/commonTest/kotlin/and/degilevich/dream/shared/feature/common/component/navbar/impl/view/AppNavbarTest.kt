package and.degilevich.dream.shared.feature.common.component.navbar.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.navbar.impl.preview.NavbarUIStatePreviewProvider
import and.degilevich.dream.shared.feature.common.component.navbar.impl.view.semantic.AppNavbarSemantic
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.v2.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppNavbarTest {

    private val provider = NavbarUIStatePreviewProvider()
    private val item = hasTestTag(AppNavbarSemantic.TEST_TAG_ITEM)

    @Test
    fun testDefaultState() = runComposeUiTest {
        setContent {
            ComposeAppTheme {
                AppNavbar(state = provider.provideDefault()) {}
            }
        }
        onAllNodes(item)
            .onFirst()
            .assertIsDisplayed()
    }
}
