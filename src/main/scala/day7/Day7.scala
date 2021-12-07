package fr.gplassard.adventofcode2021
package day7

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day7 {

  def optimalPosition(positions: List[Int]): Int = {
    positions.sorted.toList(positions.size / 2)
  }

  def part1(input: List[String]): Long = {
    val positions = input.flatMap(line => line.split(",")).map(_.toInt)
    val optimal = optimalPosition(positions)
    positions.map(p => Math.abs(p - optimal)).sum
  }

}
