package chapter05

import chapter02.Money
import java.time.Duration

class PercentDiscountMovie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    vararg conditions: DiscountCondition,
    private val percent: Double
) : Movie(title, runningTime, fee, *conditions) {
    override fun calculateDiscountAmount(): Money =
        fee.times(percent)
}