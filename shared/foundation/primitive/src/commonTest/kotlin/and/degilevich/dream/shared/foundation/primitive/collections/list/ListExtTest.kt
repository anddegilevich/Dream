package and.degilevich.dream.shared.foundation.primitive.collections.list

import io.kotest.matchers.collections.shouldContainExactly
import kotlin.test.Test

class ListExtTest {

    @Test
    fun `interleave - lists of equal size - items alternate by index`() {
        val result = listOf(
            listOf("a0", "a1"),
            listOf("b0", "b1"),
            listOf("c0", "c1")
        ).interleave()
        result shouldContainExactly listOf("a0", "b0", "c0", "a1", "b1", "c1")
    }

    @Test
    fun `interleave - lists of different size - remaining items keep their order`() {
        val result = listOf(
            listOf("a0", "a1", "a2"),
            listOf("b0"),
            listOf("c0", "c1")
        ).interleave()
        result shouldContainExactly listOf("a0", "b0", "c0", "a1", "c1", "a2")
    }

    @Test
    fun `interleave - some lists empty - empty lists are skipped`() {
        val result = listOf(
            emptyList(),
            listOf("b0", "b1"),
            listOf("c0")
        ).interleave()
        result shouldContainExactly listOf("b0", "c0", "b1")
    }

    @Test
    fun `interleave - single list - order is preserved`() {
        val result = listOf(
            listOf("a0", "a1", "a2")
        ).interleave()
        result shouldContainExactly listOf("a0", "a1", "a2")
    }

    @Test
    fun `interleave - no lists - result is empty`() {
        val result = emptyList<List<String>>().interleave()
        result shouldContainExactly emptyList()
    }

    @Test
    fun `interleave - all lists empty - result is empty`() {
        val result = listOf(
            emptyList<String>(),
            emptyList()
        ).interleave()
        result shouldContainExactly emptyList()
    }
}
