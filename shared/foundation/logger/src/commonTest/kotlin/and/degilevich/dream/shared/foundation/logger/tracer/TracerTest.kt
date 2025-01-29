package and.degilevich.dream.shared.foundation.logger.tracer

import kotlin.test.Test

class TracerTest {
    @Test
    fun `test getting trace velocity`() {
        for (i in 0..1000) {
            println(Tracer.getTrace(depth = 2))
        }
    }
}