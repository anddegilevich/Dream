package and.degilevich.dream.shared.foundation.tracer

import kotlin.test.Test

class TracerTest {
    @Test
    fun `test getting trace velocity`() {
        repeat(1000) {
            println(Tracer.getTrace(depth = 2))
        }
    }
}