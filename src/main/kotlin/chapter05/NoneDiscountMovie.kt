package chapter05

import chapter02.Money
import java.time.Duration

class NoneDiscountMovie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    vararg conditions: DiscountCondition,
) : Movie(title, runningTime, fee, *conditions) {
    override fun calculateDiscountAmount(): Money = Money.ZERO
}