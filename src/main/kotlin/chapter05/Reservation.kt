package chapter05

import chapter02.Money

data class Reservation(
    private val customer: Customer,
    private val screening: Screening,
    private val money: Money,
    private val audienceCount: Int
)