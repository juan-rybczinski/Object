package chapter02

import java.math.BigDecimal

data class Money(
    private val amount: BigDecimal
) {
    fun plus(amount: Money): Money = Money(this.amount.add(amount.amount))

    fun plus(amount: Long): Money = Money(this.amount.add(BigDecimal.valueOf(amount)))

    fun minus(amount: Money): Money = Money(this.amount.subtract(amount.amount))

    fun times(percent: Double): Money = Money(this.amount.multiply(BigDecimal.valueOf(percent)))

    fun isLessThan(other: Money): Boolean = amount < other.amount

    fun isGreaterThanOrEqual(other: Money): Boolean = amount > other.amount

    companion object {
        val ZERO: Money = Money.wons(0)

        fun wons(amount: Long): Money = Money(BigDecimal.valueOf(amount))
    }
}