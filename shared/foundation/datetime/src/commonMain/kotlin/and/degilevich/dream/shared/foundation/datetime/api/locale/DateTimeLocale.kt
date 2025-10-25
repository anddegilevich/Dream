package and.degilevich.dream.shared.foundation.datetime.api.locale

interface DateTimeLocale {

    fun getLocaleCode(): String

    class English : DateTimeLocale {
        override fun getLocaleCode(): String = "en"
    }
}