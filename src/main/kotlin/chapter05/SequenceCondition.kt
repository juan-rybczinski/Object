package chapter05

class SequenceCondition(
    private val sequence: Int
) {
    fun isSatisfiedBy(screening: Screening): Boolean =
        sequence == screening.sequence
}