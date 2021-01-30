package chapter02

class PercentDiscountPolicy(
    private val percent: Double,
    vararg conditions: DiscountCondition
) : DefaultDiscountPolicy(*conditions){
    override fun getDiscountAmount(screening: Screening): Money = screening.getMovieFee().times(percent)
}