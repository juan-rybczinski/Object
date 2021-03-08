import chapter06.Event
import chapter06.RecurringSchedule
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

fun main(args: Array<String>) {
//    val avatar = Movie(
//        "아바타",
//        Duration.ofMinutes(120),
//        Money.wons(10000),
//        AmountDiscountPolicy(
//            Money.wons(800),
//            SequenceCondition(1),
//            SequenceCondition(10),
//            PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
//            PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))
//        )
//    )
//
//    val titanic = Movie(
//        "타이타닉",
//        Duration.ofMinutes(180),
//        Money.wons(11000),
//        PercentDiscountPolicy(
//            0.1,
//            SequenceCondition(2),
//            PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
//            PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))
//        )
//    )
//
//    val starWars = Movie(
//        "스타워즈",
//        Duration.ofMinutes(210),
//        Money.wons(10000),
//        NoneDiscountPolicy()
//    )
//
//    println(avatar)
//    println(titanic)
//    println(starWars)

    val meeting = Event(
        "회의", LocalDateTime.of(2019, 5, 8, 20, 30), Duration.ofMinutes(30)
    )

    val schedule = RecurringSchedule(
        "회의", DayOfWeek.WEDNESDAY, LocalTime.of(10, 30), Duration.ofMinutes(30)
    )

    println(meeting)
    println(schedule)
}