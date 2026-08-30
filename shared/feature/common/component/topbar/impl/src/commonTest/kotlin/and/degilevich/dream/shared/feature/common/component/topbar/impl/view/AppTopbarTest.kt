package and.degilevich.dream.shared.feature.common.component.topbar.impl.view

import and.degilevich.dream.shared.design.theme.api.ComposeAppTheme
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarIntent
import and.degilevich.dream.shared.feature.common.component.topbar.impl.component.model.TopbarUIState
import and.degilevich.dream.shared.feature.common.component.topbar.impl.preview.TopbarUIStatePreviewProvider
import and.degilevich.dream.shared.feature.common.component.topbar.impl.view.semantic.AppTopbarSemantic
import androidx.compose.ui.test.ComposeUiTest
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.v2.runComposeUiTest
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class AppTopbarTest {

    private val provider = TopbarUIStatePreviewProvider()
    private val avatar = hasTestTag(AppTopbarSemantic.TEST_TAG_AVATAR)
    private val avatarSkeleton = hasTestTag(AppTopbarSemantic.TEST_TAG_AVATAR_SKELETON)

    @Test
    fun `render default state - shows avatar`() = runComposeUiTest {
        val intents = mutableListOf<TopbarIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(avatar)
            .assertExists()
            .assertIsDisplayed()
        intents.shouldBeEmpty()
    }

    @Test
    fun `render loading state - shows avatar skeleton`() = runComposeUiTest {
        val intents = mutableListOf<TopbarIntent>()
        setContent(
            state = TopbarUIState.empty(),
            onIntent = intents::add
        )
        onNode(avatarSkeleton)
            .assertExists()
            .assertIsDisplayed()
        onNode(avatar).assertDoesNotExist()
        intents.shouldBeEmpty()
    }

    @Test
    fun `click avatar - emits OnAvatarClicked`() = runComposeUiTest {
        val intents = mutableListOf<TopbarIntent>()
        setContent(
            state = provider.provideDefault(),
            onIntent = intents::add
        )
        onNode(avatar).performClick()
        waitUntil(conditionDescription = "intent emitted") { intents.isNotEmpty() }
        intents.shouldContainExactly(TopbarIntent.OnAvatarClicked)
    }

    private fun ComposeUiTest.setContent(
        state: TopbarUIState,
        onIntent: (TopbarIntent) -> Unit = {}
    ) = setContent {
        ComposeAppTheme {
            AppTopbar(
                state = state,
                onIntent = onIntent
            )
        }
    }
}
