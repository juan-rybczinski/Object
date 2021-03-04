package chapter05

class SequenceCondition(
    private val sequence: Int
) : DiscountCondition {
    override fun isSatisfiedBy(screening: Screening): Boolean =
        sequence == screening.sequence
}