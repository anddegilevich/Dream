package and.degilevich.dream.shared.feature.auth.domain.api.usecase

interface HasActiveSessionUseCase {
    suspend operator fun invoke(): Boolean
}
