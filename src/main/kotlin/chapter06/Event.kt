package chapter06

import java.time.Duration
import java.time.LocalDateTime

data class Event(
    private val subject: String,
    private var from: LocalDateTime,
    private val duration: Duration
) {
    fun isSatisfied(schedule: RecurringSchedule): Boolean {
        if (from.dayOfWeek != schedule.dayOfWeek ||
            from.toLocalTime() != schedule.from ||
            duration != schedule.duration
        ) {
            return false
        }

        return true
    }

    fun reschedule(schedule: RecurringSchedule) {
        from = LocalDateTime.of(
            from.toLocalDate().plusDays(dayDistance(schedule)),
            schedule.from
        )
    }

    private fun dayDistance(schedule: RecurringSchedule): Long =
        (schedule.dayOfWeek.value - from.dayOfWeek.value).toLong()
}