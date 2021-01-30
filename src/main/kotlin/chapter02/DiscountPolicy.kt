package chapter02

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}