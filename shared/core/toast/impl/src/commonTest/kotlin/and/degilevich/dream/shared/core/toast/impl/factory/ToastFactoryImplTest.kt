package and.degilevich.dream.shared.core.toast.impl.factory

import and.degilevich.dream.shared.core.toast.impl.mapper.FakeErrorToMessageMapper
import and.degilevich.dream.shared.resource.test.FakeResourceManager
import io.kotest.matchers.shouldBe
import kotlin.test.Test

class ToastFactoryImplTest {

    @Test
    fun `createMessageToast - error - uses the mapped message`() {
        val toastFactory = ToastFactoryImpl(
            resourceManager = FakeResourceManager(),
            errorToMessageMapper = FakeErrorToMessageMapper(onMap = { "mapped-message" })
        )

        val toast = toastFactory.createMessageToast(error = IllegalStateException("raw"))

        toast.message shouldBe "mapped-message"
    }

    @Test
    fun `createMessageToast - error - passes the error to the mapper`() {
        val error = IllegalStateException("raw")
        val mapped = mutableListOf<Throwable>()
        val toastFactory = ToastFactoryImpl(
            resourceManager = FakeResourceManager(),
            errorToMessageMapper = FakeErrorToMessageMapper(
                onMap = { item ->
                    mapped.add(item)
                    "mapped-message"
                }
            )
        )

        toastFactory.createMessageToast(error = error)

        mapped shouldBe listOf(error)
    }

    @Test
    fun `createRepeatToast - error - uses the mapped message`() {
        val toastFactory = ToastFactoryImpl(
            resourceManager = FakeResourceManager(onGetString = { "repeat" }),
            errorToMessageMapper = FakeErrorToMessageMapper(onMap = { "mapped-message" })
        )

        val toast = toastFactory.createRepeatToast(
            error = IllegalStateException("raw"),
            onRepeat = {}
        )

        toast.message shouldBe "mapped-message"
    }
}
