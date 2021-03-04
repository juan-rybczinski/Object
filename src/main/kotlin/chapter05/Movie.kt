package chapter05

import chapter02.Money
import java.time.Duration

abstract class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    vararg conditions: DiscountCondition
) {
    private val conditionList = mutableListOf(*conditions)

    fun calculateMovieFee(screening: Screening): Money {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount())
        }

        return fee
    }

    protected abstract fun calculateDiscountAmount(): Money

    private fun isDiscountable(screening: Screening): Boolean =
        conditionList.stream().anyMatch {
            it.isSatisfiedBy(screening)
        }
}