package and.degilevich.dream.shared.feature.category.component.list.impl.component

import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListIntent
import and.degilevich.dream.shared.feature.category.component.list.api.component.model.CategoryListSideEffect
import and.degilevich.dream.shared.feature.category.component.list.impl.component.model.CategoryListState
import and.degilevich.dream.shared.feature.category.domain.api.usecase.FetchCategoriesUseCase
import and.degilevich.dream.shared.feature.category.model.core.api.data.CategoryData
import and.degilevich.dream.shared.feature.category.model.core.api.method.getCategories.GetCategoriesParams
import and.degilevich.dream.shared.resource.api.pallet.PalletColor
import and.degilevich.dream.shared.template.component.impl.BaseDomainComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnCreate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.component.inject

internal class CategoryListDomainComponent(
    componentContext: ComponentContext
) : BaseDomainComponent<CategoryListState, CategoryListIntent, CategoryListSideEffect>(
    componentContext = componentContext,
    stateConservator = CategoryListStateConservator()
) {

    private val fetchCategoriesUseCase: FetchCategoriesUseCase by inject()

    init {
        subscribeToLifecycle()
    }

    override fun handleIntent(intent: CategoryListIntent) {
        when (intent) {
            is CategoryListIntent.OnCategoryClicked -> Unit // FIXME: Implement later
        }
    }

    private fun subscribeToLifecycle() {
        doOnCreate {
            fetchCategories()
        }
    }

    private fun fetchCategories() = scope.launch {
        val params = GetCategoriesParams(
            limit = CATEGORIES_LIMIT,
            offset = 0
        )
        try {
            setLoading(true)
            withContext(context = Dispatchers.IO) { fetchCategoriesUseCase(params) }
                .onSuccess { result ->
                    setCategories(categories = result.categories)
                }
                .onFailure { error ->
                    toastController.showRepeatToast(
                        error = error,
                        onRepeat = ::fetchCategories
                    )
                }
        } finally {
            setLoading(false)
        }
    }

    private fun setCategories(categories: List<CategoryData>) = reduce {
        copy(
            categories = categories,
            categoryToColorMap = categories.associate { category ->
                category.id to PalletColor.entries.random()
            }
        )
    }

    private fun setLoading(isLoading: Boolean) = reduce {
        copy(isLoading = isLoading)
    }

    private companion object {
        const val CATEGORIES_LIMIT = 6
    }
}