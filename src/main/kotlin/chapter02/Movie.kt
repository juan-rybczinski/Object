package chapter02

import java.time.Duration

data class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val defaultDiscountPolicy: DefaultDiscountPolicy
) {
    fun getFee(): Money = fee

    fun calculateMovieFee(screening: Screening): Money {
        return fee.minus(defaultDiscountPolicy.calculateDiscountAmount(screening))
    }
}