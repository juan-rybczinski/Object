package chapter05

import chapter02.Money
import java.time.LocalDateTime

data class Screening(
    private val movie: Movie,
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    fun reserve(customer: Customer, audienceCount: Int): Reservation =
        Reservation(customer, this, calculateFee(audienceCount), audienceCount)

    private fun calculateFee(audienceCount: Int): Money = movie.calculateMovieFee(this).times(audienceCount.toDouble())
}