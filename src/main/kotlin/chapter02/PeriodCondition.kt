package chapter02

import java.time.DayOfWeek
import java.time.LocalTime

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean =
        screening.whenScreened.dayOfWeek == dayOfWeek &&
                startTime > screening.whenScreened.toLocalTime() &&
                endTime < screening.whenScreened.toLocalTime()
}