package and.degilevich.dream.shared.feature.auth.domain.api.usecase

interface LoginUseCase {
    suspend operator fun invoke(): Result<Unit>
}
