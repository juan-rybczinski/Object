package chapter02

import java.math.BigDecimal

class Movie {
    fun getFee(): Money {
        return Money(BigDecimal(0))
    }

    fun calculateMovieFee(screening: Screening): Money {
        return Money(BigDecimal(0))
    }
}