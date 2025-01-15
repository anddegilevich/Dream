package and.degilevich.dream.shared.app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform