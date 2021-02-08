package chapter04

import chapter02.Money
import chapter04.MovieType.*

class ReservationAgency {
    fun reserve(screening: Screening, customer: Customer, audienceCount: Int): Reservation {
        val movie = screening.movie

        var discountable = false
        for (condition in movie.discountConditions) {
            if (condition.type == DiscountConditionType.PERIOD) {
                discountable = screening.whenScreened.dayOfWeek == condition.dayOfWeek &&
                        condition.startTime <= screening.whenScreened.toLocalTime() &&
                        condition.endTime >= screening.whenScreened.toLocalTime()
            } else {
                discountable = condition.sequence == screening.sequence
            }

            if (discountable) break
        }

        val fee = if (discountable) {
            val discountAmount = when (movie.movieType) {
                AMOUNT_DISCOUNT -> {
                    movie.discountAmount
                }
                PERCENT_DISCOUNT -> {
                    movie.fee.times(movie.discountPercent)
                }
                NONE_DISCOUNT -> {
                    Money.ZERO
                }
            }

            movie.fee.minus(discountAmount).times(audienceCount.toDouble())
        } else {
            movie.fee
        }

        return Reservation(customer, screening, fee, audienceCount)
    }
}