package and.degilevich.dream.shared.foundation.datetime.api.common

class TimestampDateTimeInput(
    date: String
) : DateTimeInput by DateTimeInput.FromString(
    date = date,
    format = DateTimeFormat.Defaults.TIMESTAMP
)