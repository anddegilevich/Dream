package and.degilevich.dream.shared.core.toast.impl.mapper

import and.degilevich.dream.Res
import and.degilevich.dream.error
import and.degilevich.dream.error_no_connection
import and.degilevich.dream.error_timeout
import and.degilevich.dream.shared.core.network.api.exception.NetworkTimeoutException
import and.degilevich.dream.shared.core.network.api.exception.NoNetworkConnectionException
import and.degilevich.dream.shared.core.service.api.exception.ServiceErrorStatus
import and.degilevich.dream.shared.core.service.api.exception.ServiceException
import and.degilevich.dream.shared.resource.test.FakeResourceManager
import dev.icerock.moko.resources.StringResource
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ErrorToMessageMapperImplTest {

    @Test
    fun `map - network timeout - shows timeout`() {
        messageFor(error = NetworkTimeoutException(cause = IllegalStateException("timeout"))) shouldBe "timeout"
    }

    @Test
    fun `map - no network connection - shows no connection`() {
        val error = NoNetworkConnectionException(cause = IllegalStateException("offline"))

        messageFor(error = error) shouldBe "no-connection"
    }

    @Test
    fun `map - other error with message - shows its message`() {
        messageFor(error = IllegalStateException("something broke")) shouldBe "something broke"
    }

    @Test
    fun `map - service exception - returns the service mapper result`() {
        val mapper = createMapper(
            serviceExceptionToMessageMapper = FakeServiceExceptionToMessageMapper(onMap = { "service-message" })
        )

        mapper.map(item = serviceError()) shouldBe "service-message"
    }

    @Test
    fun `map - service exception - passes it to the service mapper unchanged`() {
        val error = serviceError()
        val mapped = mutableListOf<ServiceException>()
        val mapper = createMapper(
            serviceExceptionToMessageMapper = FakeServiceExceptionToMessageMapper(
                onMap = { item ->
                    mapped.add(item)
                    "service-message"
                }
            )
        )

        mapper.map(item = error)

        mapped shouldBe listOf(error)
    }

    private fun messageFor(error: Throwable): String {
        return createMapper().map(item = error)
    }

    private fun serviceError(): ServiceException {
        return ServiceException(
            status = ServiceErrorStatus.NOT_FOUND,
            serviceMessage = "spotify-message",
            cause = IllegalStateException("response")
        )
    }

    private fun createMapper(
        serviceExceptionToMessageMapper: ServiceExceptionToMessageMapper = FakeServiceExceptionToMessageMapper()
    ): ErrorToMessageMapperImpl {
        val strings: Map<StringResource, String> = mapOf(
            Res.strings.error to "generic-error",
            Res.strings.error_timeout to "timeout",
            Res.strings.error_no_connection to "no-connection"
        )
        return ErrorToMessageMapperImpl(
            resourceManager = FakeResourceManager(onGetString = { resource -> strings.getValue(resource) }),
            serviceExceptionToMessageMapper = serviceExceptionToMessageMapper
        )
    }
}
