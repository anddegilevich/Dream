package and.degilevich.dream.shared.core.storage.api.exception

class StorageValueNotFoundException(key: String) : Exception("No value stored for key: $key")
