package chapter04

import chapter02.Money
import chapter04.DiscountConditionType.PERIOD
import chapter04.MovieType.*
import java.time.Duration
import java.time.LocalDateTime

data class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double
) {
    fun calculateAmountDiscountedFee(): Money {
        if (movieType != AMOUNT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee.minus(fee.times(discountPercent))
    }

    fun calculatedNoneDiscountedFee(): Money {
        if (movieType != NONE_DISCOUNT) {
            throw IllegalArgumentException()
        }

        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        for (condition in discountConditions) {
            if (condition.type == PERIOD) {
                if (condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())) {
                    return true
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true
                }
            }
        }
        return false
    }
}