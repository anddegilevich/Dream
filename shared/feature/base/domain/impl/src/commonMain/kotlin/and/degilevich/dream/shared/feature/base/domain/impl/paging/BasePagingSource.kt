package and.degilevich.dream.shared.feature.base.domain.impl.paging

import and.degilevich.dream.shared.feature.base.domain.api.paging.PagingSource
import and.degilevich.dream.shared.feature.base.domain.api.paging.model.PageData
import and.degilevich.dream.shared.feature.base.domain.api.paging.model.PagingSourceState
import and.degilevich.dream.shared.foundation.abstraction.id.Identified
import and.degilevich.dream.shared.foundation.abstraction.id.ext.distinctById
import and.degilevich.dream.shared.foundation.primitive.reflection.className
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.coroutines.coroutineScope
import com.arkivanov.essenty.lifecycle.doOnDestroy
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.withContext
import kotlinx.serialization.KSerializer

abstract class BasePagingSource<T : Identified>(
    componentContext: ComponentContext,
    private val pageSize: Int,
    itemSerializer: KSerializer<T>
) : PagingSource<T> {

    private val dataMutable = MutableStateFlow<List<T>>(emptyList())
    override val data: StateFlow<List<T>> = dataMutable.asStateFlow()

    private val isLoadingMutable = MutableStateFlow(false)
    override val isLoading: StateFlow<Boolean> = isLoadingMutable.asStateFlow()

    private val totalCountMutable = MutableStateFlow(0)
    override val totalCount: StateFlow<Int> = totalCountMutable.asStateFlow()

    private val errorChannel = Channel<Throwable>(capacity = Channel.BUFFERED)
    override val errors: Flow<Throwable> = errorChannel.receiveAsFlow()

    private val stateKey: String = this::class.className()

    private val pagingSourceStateSerializer = PagingSourceState.serializer(itemSerializer)

    private val scope = componentContext.coroutineScope()

    private val mutex = Mutex()

    private var offset = 0
    private var isLastPageReached = false

    init {
        attachTo(componentContext = componentContext)
    }

    final override suspend fun loadFirstPage() {
        if (offset > 0) return
        loadNextPage()
    }

    final override suspend fun loadNextPage() {
        if (!mutex.tryLock()) return
        try {
            scope.launch { executeLoadPage() }.join()
        } finally {
            mutex.unlock()
        }
    }

    final override fun reset() {
        scope.coroutineContext.cancelChildren()
        offset = 0
        isLastPageReached = false
        dataMutable.value = emptyList()
        totalCountMutable.value = 0
    }

    protected abstract suspend fun loadPage(
        limit: Int,
        offset: Int
    ): Result<PageData<T>>

    private fun merge(
        data: List<T>,
        page: PageData<T>
    ): List<T> = (data + page.items).distinctById()

    private fun attachTo(componentContext: ComponentContext) = with(componentContext) {
        stateKeeper.consume(
            key = stateKey,
            strategy = pagingSourceStateSerializer
        )?.let(::restoreSourceState)
        stateKeeper.register(
            key = stateKey,
            strategy = pagingSourceStateSerializer,
            supplier = ::snapshotSourceState
        )
        lifecycle.doOnDestroy {
            stateKeeper.unregister(key = stateKey)
            scope.cancel()
        }
    }

    private suspend fun executeLoadPage() {
        if (isLastPageReached) return
        isLoadingMutable.value = true
        try {
            withContext(context = Dispatchers.IO) {
                loadPage(
                    limit = pageSize,
                    offset = offset
                )
            }
                .onSuccess { page ->
                    appendPage(page = page)
                }
                .onFailure { error ->
                    errorChannel.send(error)
                }
        } finally {
            isLoadingMutable.value = false
        }
    }

    private fun appendPage(page: PageData<T>) {
        val total = page.total
        offset += pageSize
        dataMutable.value = merge(
            data = dataMutable.value,
            page = page
        )
        totalCountMutable.value = total
        isLastPageReached = page.items.size < pageSize || offset >= total
    }

    private fun restoreSourceState(pagingSourceState: PagingSourceState<T>) {
        dataMutable.value = pagingSourceState.data
        offset = pagingSourceState.offset
        totalCountMutable.value = pagingSourceState.totalCount
        isLastPageReached = pagingSourceState.isLastPageReached
    }

    private fun snapshotSourceState() = PagingSourceState(
        data = dataMutable.value,
        offset = offset,
        totalCount = totalCountMutable.value,
        isLastPageReached = isLastPageReached
    )
}
