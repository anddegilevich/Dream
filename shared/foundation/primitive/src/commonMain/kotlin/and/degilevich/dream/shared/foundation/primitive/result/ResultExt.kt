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

inline fun <R, T> Result<T>.foldResultSuccess(
    onSuccess: (value: T) -> R,
): Result<R> {
    return foldResult { value ->
        Result.success(
            onSuccess(value)
        )
    }
}

@Suppress("ReturnCount")
inline fun <T1, T2, R> fold(
    result1: Result<T1>,
    result2: Result<T2>,
    onSuccess: (value1: T1, value2: T2) -> R,
    onFailure: (exception: Throwable) -> R,
): R {
    val value1 = result1.fold(
        onSuccess = { value -> value },
        onFailure = { error -> return onFailure(error) }
    )
    val value2 = result2.fold(
        onSuccess = { value -> value },
        onFailure = { error -> return onFailure(error) }
    )
    return onSuccess(value1, value2)
}

inline fun <T1, T2, R> foldResults(
    result1: Result<T1>,
    result2: Result<T2>,
    onResult: (value1: T1, value2: T2) -> Result<R>,
): Result<R> {
    return fold(
        result1 = result1,
        result2 = result2,
        onSuccess = { value1, value2 ->
            onResult(value1, value2)
        },
        onFailure = { error ->
            Result.failure(error)
        }
    )
}

inline fun <T1, T2, R> foldResultsSuccesses(
    result1: Result<T1>,
    result2: Result<T2>,
    onSuccess: (value1: T1, value2: T2) -> R,
): Result<R> {
    return foldResults(
        result1 = result1,
        result2 = result2,
        onResult = { value1, value2 ->
            Result.success(
                onSuccess(value1, value2)
            )
        }
    )
}