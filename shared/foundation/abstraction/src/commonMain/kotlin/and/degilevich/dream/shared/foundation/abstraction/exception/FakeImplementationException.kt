package and.degilevich.dream.shared.foundation.abstraction.exception

class FakeImplementationException : Exception("Fake implementation. Lambda shouldn't be called")

fun fakeImplementationError(): Nothing = throw FakeImplementationException()