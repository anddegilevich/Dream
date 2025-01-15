package and.degilevich.dream.shared.app

actual fun getPlatform(): Platform {
    return object : Platform {
        override val name: String = "Android"
    }
}