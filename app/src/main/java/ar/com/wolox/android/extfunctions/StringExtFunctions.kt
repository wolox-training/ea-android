package ar.com.wolox.android.extfunctions

import java.time.Instant
import java.time.temporal.ChronoUnit

fun String.isValidEmail(): Boolean = this.let { android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches() }

fun deltaTime(lastUpdated: String): String {

    val currentTime = Instant.now()
    val lastUpdatedTime = Instant.parse(lastUpdated)

    return when (val period = ChronoUnit.MINUTES.between(lastUpdatedTime, currentTime)) {
        in 0..60 -> "${period}m"
        in 60..1440 -> "${period / 60}h"
        else -> "${period / 1440}d"
    }
}