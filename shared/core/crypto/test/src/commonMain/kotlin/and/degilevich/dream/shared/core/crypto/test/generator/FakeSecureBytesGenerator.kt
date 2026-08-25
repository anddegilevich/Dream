package and.degilevich.dream.shared.core.crypto.test.generator

import and.degilevich.dream.shared.core.crypto.api.generator.SecureBytesGenerator
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeSecureBytesGenerator(
    private val onGenerate: (Int) -> ByteArray = { fakeImplementationError() }
) : SecureBytesGenerator {

    override fun generate(size: Int): ByteArray = onGenerate(size)
}
