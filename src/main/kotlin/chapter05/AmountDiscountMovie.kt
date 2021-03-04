package chapter05

import chapter02.Money
import java.time.Duration

class AmountDiscountMovie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    vararg conditions: DiscountCondition,
    private val discountAmount: Money
) : Movie(title, runningTime, fee, *conditions) {
    override fun calculateDiscountAmount(): Money = discountAmount
}