package and.degilevich.dream.shared.core.crypto.test.service

import and.degilevich.dream.shared.core.crypto.api.service.DigestService
import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

class FakeDigestService(
    private val onSha256: (ByteArray) -> ByteArray = { fakeImplementationError() }
) : DigestService {

    override fun sha256(value: ByteArray): ByteArray = onSha256(value)
}
