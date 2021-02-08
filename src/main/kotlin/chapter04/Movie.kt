package chapter04

import chapter02.Money
import java.time.Duration

data class Movie(
    private val title: String,
    private val runningTime: Duration,
    val fee: Money,
    val discountConditions: List<DiscountCondition>,
    val movieType: MovieType,
    val discountAmount: Money,
    val discountPercent: Double
) {
}