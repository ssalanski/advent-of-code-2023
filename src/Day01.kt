fun main() {
  fun part1(input: List<String>): Int {
    return input.sumOf { line ->
      line
        .filter { char -> char.isDigit() }
        .let { it.first().digitToInt() * 10 + it.last().digitToInt() }
    }
  }

  fun part2(input: List<String>): Int {
    return input.size
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day01_test")
  println(testInput)
  check(part1(testInput) == 142)

  val input = readInput("Day01")
  part1(input).println()
  part2(input).println()
}
