package chapter02

abstract class DiscountPolicy(
    vararg conditions: DiscountCondition
) {
    private val conditionList = mutableListOf(*conditions)

    fun calculateDiscountAmount(screening: Screening): Money {
        for (condition in conditionList) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}