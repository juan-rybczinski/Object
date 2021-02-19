package chapter05

import chapter02.Money
import chapter05.MovieType.*
import java.time.Duration

data class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,
    private val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double
) {
    fun calculateMovieFee(screening: Screening): Money {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount())
        }

        return fee
    }

    private fun calculateDiscountAmount(): Money {
        when (movieType) {
            AMOUNT_DISCOUNT -> calculateAmountDiscountAmount()
            PERCENT_DISCOUNT -> calculatePercentDiscountAmount()
            NONE_DISCOUNT -> calculateNoneDiscountAmount()
        }

        throw IllegalStateException()
    }

    private fun calculateNoneDiscountAmount() = Money.ZERO

    private fun calculatePercentDiscountAmount() = fee.times(discountPercent)

    private fun calculateAmountDiscountAmount() = discountAmount

    private fun isDiscountable(screening: Screening): Boolean = discountConditions.stream()
        .anyMatch {
            it.isSatisfiedBy(screening)
        }
}