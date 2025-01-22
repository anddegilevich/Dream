package and.degilevich.dream.shared.foundation.decompose.navigator.result.collector

class NavigationResultCollector internal constructor() {

    private val collectorItemsMutable = mutableListOf<NavigationResultCollectorItem>()
    internal val collectorItems: List<NavigationResultCollectorItem> get() = collectorItemsMutable.toList()

    fun collectAny(
        key: String,
        resultCallback: (Any) -> Unit,
    ) {
        collectorItemsMutable.add(
            NavigationResultCollectorItem(
                key = key,
                resultCallback = resultCallback
            )
        )
    }

    inline fun <reified T : Any> collect(
        key: String,
        crossinline resultCallback: (T) -> Unit,
    ) {
        collectAny(
            key = key,
            resultCallback = { result ->
                val castedResult = (result as? T)
                if (castedResult != null) {
                    resultCallback(castedResult)
                }
            }
        )
    }
}