package and.degilevich.dream.shared.core.storage.api.exception

class StorageReadException(
    key: String,
    cause: Throwable?
) : Exception("Failed to read value for key: $key", cause)
