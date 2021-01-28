package chapter02

import java.time.LocalDateTime

data class Screening(
    private val movie: Movie,
    private val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun isSequence(sequence: Int) = this.sequence == sequence

    fun getMovieFee(): Money {
        return movie.getFee()
    }

    private fun calculateFee(audienceCount: Int): Money = movie.calculateMovieFee(this).times(audienceCount.toDouble())

    fun reserve(customer: Customer, audienceCount: Int): Reservation =
        Reservation(customer, this, calculateFee(audienceCount), audienceCount)
}