package and.degilevich.dream.shared.feature.common.component.drawer.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerIntent
import and.degilevich.dream.shared.feature.common.component.drawer.impl.component.model.DrawerUIState
import and.degilevich.dream.shared.feature.common.component.drawer.impl.preview.DrawerUIStatePreviewProvider
import and.degilevich.dream.shared.feature.common.component.drawer.impl.preview.DrawerHeaderUIDataPreviewProvider
import and.degilevich.dream.shared.feature.common.component.drawer.impl.view.semantic.DrawerScreenSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class DrawerScreenTest {

    private val provider = DrawerUIStatePreviewProvider()
    private val userProvider = DrawerHeaderUIDataPreviewProvider()
    private val avatar = hasTestTag(DrawerScreenSemantic.TEST_TAG_AVATAR)
    private val name = hasTestTag(DrawerScreenSemantic.TEST_TAG_NAME)
    private val headerSkeleton = hasTestTag(DrawerScreenSemantic.TEST_TAG_HEADER_SKELETON)
    private val logoutButton = hasTestTag(DrawerScreenSemantic.TEST_TAG_LOGOUT_BUTTON)

    @Test
    fun `render default state - shows user header and logout button`() = runComposeUiTest {
        val intents = mutableListOf<DrawerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(avatar).assertIsDisplayed()
        onNode(name)
            .assertIsDisplayed()
            .assertTextEquals(userProvider.provideDefault().name)
        onNode(logoutButton).assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render loading state - shows header skeleton`() = runComposeUiTest {
        val intents = mutableListOf<DrawerIntent>()
        setContent(
            state = DrawerUIState.empty(),
            onIntent = intents::add
        )
        onNode(headerSkeleton).assertIsDisplayed()
        onNode(avatar).assertDoesNotExist()
        onNode(logoutButton).assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click logout button - emits OnLogoutClicked`() = runComposeUiTest {
        val intents = mutableListOf<DrawerIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(logoutButton).performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(DrawerIntent.OnLogoutClicked)
    }

    private fun ComposeUiTest.setContent(
        state: DrawerUIState,
        onIntent: (DrawerIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            AppDrawer(
                state = state,
                onIntent = onIntent
            )
        }
    }
}
