package day01

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int = input
        .sumOf { line ->
            val firstDigit = line.first { it.isDigit() }
            val secondDigit = line.last { it.isDigit() }
            "$firstDigit$secondDigit".toInt()
        }

    fun part2(input: List<String>): Int = input
        .sumOf { line ->
            val firstDigit = line.findAnyOf(possibleDigits)?.second?.digitToInt()
            val secondDigit = line.findLastAnyOf(possibleDigits)?.second?.digitToInt()

            if (firstDigit != null && secondDigit != null) {
                firstDigit * 10 + secondDigit
            } else {
                0
            }
        }

    // test if implementation meets criteria from the description, like:
    val testInput1 = readInput("day01/Day01_test1")
    check(part1(testInput1) == 142)

    val testInput2 = readInput("day01/Day01_test2")
    check(part2(testInput2) == 281)

    val input = readInput("day01/Day01")
    part1(input).println()
    part2(input).println()
}

private val possibleDigits = setOf(
    "1", "2", "3", "4", "5", "6", "7", "8", "9",
    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
)

private fun String.digitToInt(): Int = when (this) {
    "one" -> 1
    "two" -> 2
    "three" -> 3
    "four" -> 4
    "five" -> 5
    "six" -> 6
    "seven" -> 7
    "eight" -> 8
    "nine" -> 9
    else -> single().digitToInt()
}