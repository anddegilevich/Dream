package and.degilevich.dream.shared.feature.common.component.navbar.impl.component

import and.degilevich.dream.shared.feature.base.component.impl.BaseBinderComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponent
import and.degilevich.dream.shared.feature.common.component.navbar.api.component.NavbarComponentListener
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarIntent
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarSideEffect
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.component.model.NavbarUIState
import and.degilevich.dream.shared.feature.common.component.navbar.impl.view.AppNavbar
import and.degilevich.dream.shared.foundation.decompose.compose.component.state
import and.degilevich.dream.shared.foundation.primitive.primitives.number.int.orNullIfNegative
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

internal class NavbarComponentImpl(
    componentContext: ComponentContext,
    private val listener: NavbarComponentListener
) : BaseBinderComponent<
    NavbarUIState,
    NavbarIntent,
    NavbarSideEffect,
    NavbarState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        NavbarDomainComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = NavbarUIState.empty(),
    uiStateMapper = NavbarUIStateMapper()
),
    NavbarComponent {

    private val scope = coroutineScope()

    init {
        observeSelectedItem()
    }

    @Composable
    override fun Render() {
        AppNavbar(
            state = state(),
            onIntent = ::handleIntent
        )
    }

    private fun observeSelectedItem() = scope.launch {
        state.collectLatest { uiState ->
            val selectedIndex = uiState.items.indexOfFirst { item ->
                item.isSelected
            }.orNullIfNegative() ?: return@collectLatest
            listener.onNavbarItemSelected(index = selectedIndex)
        }
    }
}