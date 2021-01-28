package chapter02

data class Reservation(
    val customer: Customer,
    val screening: Screening,
    val calculateFee: Money,
    val audienceCount: Int
)