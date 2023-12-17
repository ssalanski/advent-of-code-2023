fun main() {
  fun part1(input: List<String>): Int {
    return input.sumOf { line ->
      line
        .filter { char -> char.isDigit() }
        .let { it.first().digitToInt() * 10 + it.last().digitToInt() }
    }
  }

  val decodermap = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
  ).withDefault { digit -> digit[0].digitToInt() }

  fun part2(input: List<String>): Int {
    return input.sumOf { line ->
      println("========")
      println(line)
      val a = Regex("(one|two|three|four|five|six|seven|eight|nine|[1-9])").find(line)
      println(a)
      a?.let{
        println(it.groupValues)
        println(it.groupValues.first())
        println(decodermap.getValue(it.groupValues.first()))
      }


      val first = decodermap.getValue(
        Regex("(one|two|three|four|five|six|seven|eight|nine|[1-9])").find(line)
          ?.groupValues
          ?.first()
          .orEmpty()
      )
      val last = decodermap.getValue(
        Regex("(eno|owt|eerht|ruof|evif|xis|neves|thgie|enin|[1-9])").find(line.reversed())
          ?.groupValues
          ?.first()
          ?.reversed()
          .orEmpty()
      )

      first * 10 + last
    }
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day01_test")
  println(testInput)
  check(part1(testInput) == 142)

  val input = readInput("Day01")
  part1(input).println()
  part2(input).println()
}
