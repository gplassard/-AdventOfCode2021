package fr.gplassard.adventofcode2021
package day3

object Day3 {

  def part1(diagnostic: List[String]): Int = {
    val bitsLength = diagnostic.headOption.map(_.length).getOrElse(0)
    val emptyCounters = (1 to bitsLength).map(_ => 0)

    val gammaBits = diagnostic
      .map(line => line.split(""))
      .foldLeft(emptyCounters) { (counters, line) =>
        counters.zip(line).map((count, bit) => count + bit.toInt)
      }
      .map(count => if (count > diagnostic.length / 2) 1 else 0)

    val epsilonBits = gammaBits.map(bit => 1 - bit)

    val gamma = Integer.parseInt(gammaBits.mkString("0", "", ""), 2)
    val epsilon = Integer.parseInt(epsilonBits.mkString("0", "", ""), 2)
    gamma * epsilon
  }


}
