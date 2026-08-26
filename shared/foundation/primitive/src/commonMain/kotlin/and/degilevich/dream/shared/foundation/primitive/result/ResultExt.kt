package and.degilevich.dream.shared.foundation.primitive.result

inline fun <R, T> Result<T>.foldResult(
    onResult: (value: T) -> Result<R>,
): Result<R> {
    return fold(
        onSuccess = { value ->
            onResult(value)
        },
        onFailure = { error ->
            Result.failure(error)
        }
    )
}