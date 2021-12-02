package fr.gplassard.adventofcode2021
package day1

object Day1 {

  def countIncreases(measurements: List[Int]): Int =
    if (measurements.length <= 1) 0
    else measurements.zip(measurements.tail)
      .count((a, b) => b > a)

}
