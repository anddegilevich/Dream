package and.degilevich.dream.shared.foundation.abstraction.comparator

abstract class OrderComparator<T>(
    private val order: List<T>
) : Comparator<T> {

    final override fun compare(a: T, b: T): Int {
        val aIndex = order.indexOf(a)
        val bIndex = order.indexOf(b)
        return aIndex.compareTo(bIndex)
    }
}