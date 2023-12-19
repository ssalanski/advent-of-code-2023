import kotlin.math.max

fun main() {
  fun part1(input: List<String>): Int {
    val maxRed = 12
    val maxGreen = 13
    val maxBlue = 14
    return input.mapIndexedNotNull { idx, line ->
      (idx + 1).takeIf {
        line.split(":").last().split(";").all { grab ->
          grab.trim().split(",").associate {
            it.trim().split(" ").let {
              it.last() to it.first().toInt()
            }
          }.withDefault { 0 }.let {
            it.getValue("red") <= maxRed && it.getValue("blue") <= maxBlue && it.getValue("green") <= maxGreen
          }
        }
      }
    }.sum()
  }

  fun part2(input: List<String>): Int {
    return input.sumOf { line ->
      line.split(":").last().split(";").map { grab ->
        grab.trim().split(",").associate {
          it.trim().split(" ").let {
            it.last() to it.first().toInt()
          }
        }.withDefault { 0 }
      }
        .reduce(::maxValues)
        .values
        .product()
    }
  }

  // test if implementation meets criteria from the description, like:
  val testInput = readInput("Day02_test")
  println(testInput)
  check(part1(testInput) == 8)

  val input = readInput("Day02")
  part1(input).println()
  part2(input).println()
}

private fun maxValues(acc: Map<String, Int>, map: Map<String, Int>): Map<String, Int> {
  return (acc.keys + map.keys).associateWith { k -> max(acc[k] ?: 0, map[k] ?: 0) }
}
private fun Collection<Int>.product(): Int {
  var product = 1
  for (element in this) {
    product *= element
  }
  return product
}

