package fr.gplassard.adventofcode2021
package day1

object Day1 {

  def part1(measurements: List[Int]): Int =
    if (measurements.length <= 1) 0
    else measurements.zip(measurements.tail)
      .count((a, b) => b > a)

  def part2(measurements: List[Int]): Int = {
    if (measurements.length <= 3) 0
    else {
      val tripletsSums = measurements.zip(measurements.tail).zip(measurements.tail.tail)
        .map{case ((a,b), c) => a + b + c}

      part1(tripletsSums)
    }
  }

}
