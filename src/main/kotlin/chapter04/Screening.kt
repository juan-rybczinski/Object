package chapter04

import chapter02.Money
import chapter04.MovieType.*
import java.time.LocalDateTime

data class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {
    fun calculateFee(audienceCount: Int): Money {
        when (movie.movieType) {
            AMOUNT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount.toDouble())
                }
            }
            PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount.toDouble())
                }
            }
            NONE_DISCOUNT -> {
                return movie.calculatedNoneDiscountedFee().times(audienceCount.toDouble())
            }
        }
        return movie.calculatedNoneDiscountedFee().times(audienceCount.toDouble())
    }
}