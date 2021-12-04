package fr.gplassard.adventofcode2021
package day3

import scala.annotation.tailrec

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


  def oxygenRating(diagnostic: List[String]): String = {
    @tailrec
    def rec(elements: List[String], index: Int): List[String] = {
      if (elements.length == 1) elements
      else {
        val counts1 = elements.count(s => s(index) == '1')
        val counts0 = elements.length - counts1
        val valueToKeep = if (counts1 >= counts0) '1' else '0'
        val remaining = elements.filter(s => s(index) == valueToKeep)
        rec(remaining, index + 1)
      }
    }
    rec(diagnostic, 0).head
  }

  def co2Rating(diagnostic: List[String]): String = {
    @tailrec
    def rec(elements: List[String], index: Int): List[String] = {
      if (elements.length == 1) elements
      else {
        val counts1 = elements.count(s => s(index) == '1')
        val counts0 = elements.length - counts1
        val valueToKeep = (counts0, counts1) match {
          case (0, _) => '1'
          case (_, 0) => '0'
          case (zeros, ones) if ones >= zeros => '0'
          case _ => '1'
        }
        val remaining = elements.filter(s => s(index) == valueToKeep)
        rec(remaining, index + 1)
      }
    }
    rec(diagnostic, 0).head
  }

  def part2(diagnostic: List[String]): Int = {
    val oxygen = Integer.parseInt(oxygenRating(diagnostic), 2)
    val co2 = Integer.parseInt(co2Rating(diagnostic), 2)

    oxygen * co2
  }
}
