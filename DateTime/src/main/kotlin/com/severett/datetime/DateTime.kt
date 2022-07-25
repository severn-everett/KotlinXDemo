package com.severett.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.toInstant

fun main() {
    val beginningOfYear = "2022-01-01T00:00:00.000Z".toInstant()
    val now = Clock.System.now()
    val timeElapsed = now - beginningOfYear
    println("Day ${timeElapsed.inWholeDays + 1} of the year.")
}
