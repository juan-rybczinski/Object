package chapter05

import chapter05.DiscountConditionType.PERIOD
import chapter05.DiscountConditionType.SEQUENCE
import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    private val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) {
    fun isSatisfiedBy(screening: Screening): Boolean =
        when (type) {
            PERIOD -> isSatisfiedByPeriod(screening)
            SEQUENCE -> isSatisfiedBySequence(screening)
        }

    private fun isSatisfiedBySequence(screening: Screening): Boolean =
        sequence == screening.sequence

    private fun isSatisfiedByPeriod(screening: Screening): Boolean =
        dayOfWeek == screening.whenScreened.dayOfWeek &&
                startTime <= screening.whenScreened.toLocalTime() &&
                endTime >= screening.whenScreened.toLocalTime()

}
