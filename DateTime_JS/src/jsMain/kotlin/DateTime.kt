import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

@JsModule("@js-joda/timezone")
@JsNonModule
external object JsJodaTimeZoneModule

@Suppress("unused")
private val jsJodaTz = JsJodaTimeZoneModule

fun main() {
    val beginningOfYear = "2022-01-01T00:00:00.000Z".let(Instant::parse)
    val now = Clock.System.now()
    val timeElapsed = now - beginningOfYear
    println("Day ${timeElapsed.inWholeDays + 1} of the year.")
    val newYorkTimeZone = TimeZone.of("America/New_York")
    val nycTime = now.toLocalDateTime(newYorkTimeZone)
    println("The time in New York City is $nycTime")
}
