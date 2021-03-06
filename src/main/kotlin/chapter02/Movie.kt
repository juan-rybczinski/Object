package chapter02

import java.time.Duration

data class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val DiscountPolicy: DiscountPolicy
) {
    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(DiscountPolicy.calculateDiscountAmount(screening))
    }
}