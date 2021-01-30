package chapter02

abstract class DefaultDiscountPolicy(
    vararg conditions: DiscountCondition
) : DiscountPolicy {
    private val conditionList = mutableListOf(*conditions)

    override fun calculateDiscountAmount(screening: Screening): Money {
        for (condition in conditionList) {
            if (condition.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}