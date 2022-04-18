package ru.netology

const val START = 0
const val MINUTE = 60
const val HOUR = 3600
const val DAY = 24 * 60 * 60
const val TWO_DAYS = 2 * 24 * 60 * 60
const val THREE_DAYS = 3 * 24 * 60 * 60

fun main() {
    printTime(1_260)
    printTime(120)
    printTime(660)
    printTime(1_500)

    printTime(75_600)
    printTime(7_200)
    printTime(39_600)
    printTime(54_000)

    printTime(86_450)
    printTime(172_837)
    printTime(259_300)
}

fun agoToText(time: Int): String {
    return when (time) {
        in START..MINUTE -> "только что"
        in MINUTE + 1..HOUR -> outputMinutes(time)
        in HOUR + 1..DAY -> outputHours(time)
        in DAY + 1..TWO_DAYS -> "сегодня"
        in TWO_DAYS + 1..THREE_DAYS -> "вчера"
        else -> "давно"
    }
}

fun outputMinutes(time: Int): String {
    val minutes = time / MINUTE
    return when {
        minutes in 5..20 -> "$minutes минут назад"
        minutes % 10 == 1 -> "$minutes минуту назад"
        minutes % 10 in 2..4 -> "$minutes минуты назад"
        else -> "$minutes минут назад"
    }
}

fun outputHours(time: Int): String {
    val hours = time / HOUR
    return when {
        hours in 5..20 -> "$hours часов назад"
        hours % 10 == 1 -> "$hours час назад"
        hours % 10 in 2..4 -> "$hours часа назад"
        else -> "$hours часов назад"
    }
}

fun printTime(time: Int) {
    println("был(а) в сети ${agoToText(time)}")
}