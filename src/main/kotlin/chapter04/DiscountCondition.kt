package chapter04

import java.time.DayOfWeek
import java.time.LocalTime

data class DiscountCondition(
    val type: DiscountConditionType,
    val sequence: Int,
    val dayOfWeek: DayOfWeek,
    val startTime: LocalTime,
    val endTime: LocalTime
) {
}