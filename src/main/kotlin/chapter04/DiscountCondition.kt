package chapter04

import chapter04.DiscountConditionType.PERIOD
import chapter04.DiscountConditionType.SEQUENCE
import java.time.DayOfWeek
import java.time.LocalTime

data class DiscountCondition(
    val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) {
    fun isDiscountable(dayOfWeek: DayOfWeek, time: LocalTime): Boolean {
        if (type != PERIOD) {
            throw IllegalArgumentException()
        }

        return this.dayOfWeek == dayOfWeek &&
                this.startTime <= time &&
                this.endTime >= time
    }

    fun isDiscountable(sequence: Int): Boolean {
        if (type != SEQUENCE) {
            throw IllegalArgumentException()
        }

        return this.sequence == sequence
    }
}