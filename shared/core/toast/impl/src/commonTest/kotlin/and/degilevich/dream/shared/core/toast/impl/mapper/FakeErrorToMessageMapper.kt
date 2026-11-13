package and.degilevich.dream.shared.core.toast.impl.mapper

import and.degilevich.dream.shared.foundation.abstraction.exception.fakeImplementationError

internal class FakeErrorToMessageMapper(
    private val onMap: (Throwable) -> String = { fakeImplementationError() }
) : ErrorToMessageMapper {

    override fun map(item: Throwable): String = onMap(item)
}
