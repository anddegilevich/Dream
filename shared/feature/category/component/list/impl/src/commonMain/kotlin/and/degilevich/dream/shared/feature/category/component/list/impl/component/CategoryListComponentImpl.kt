package and.degilevich.dream.shared.feature.category.component.list.impl.component

import and.degilevich.dream.shared.feature.category.component.list.api.component.CategoryListComponent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListIntent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListSideEffect
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListUIState
import and.degilevich.dream.shared.feature.category.component.list.impl.component.model.CategoryListState
import and.degilevich.dream.shared.template.component.impl.BaseBinderComponent
import com.arkivanov.decompose.ComponentContext

class CategoryListComponentImpl(
    componentContext: ComponentContext
) : BaseBinderComponent<
    CategoryListUIState,
    CategoryListIntent,
    CategoryListSideEffect,
    CategoryListState,
    >(
    componentContext = componentContext,
    domainComponentFactory = { childComponentContext ->
        CategoryListDomainComponent(
            componentContext = childComponentContext
        )
    },
    initialUIState = CategoryListUIState.empty(),
    uiStateMapper = CategoryListUIStateMapper()
),
    CategoryListComponent