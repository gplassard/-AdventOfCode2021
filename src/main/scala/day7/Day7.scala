package fr.gplassard.adventofcode2021
package day7

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day7 {

  def optimalPosition(positions: List[Int]): Int = {
    positions.sorted.toList(positions.size / 2)
  }

  def optimalPositionPart2(positions: List[Int]): List[Int] = {
    val sum = positions.sum.toDouble
    val elements = positions.length.toDouble
    val mean = math.round(sum / elements).toInt
    List(mean - 1, mean, mean + 1)
  }

  def part1(input: List[String]): Long = {
    val positions = input.flatMap(line => line.split(",")).map(_.toInt)
    val optimal = optimalPosition(positions)
    positions.map(p => Math.abs(p - optimal)).sum
  }

  def costPart2(distance: Int): Int = {
    (distance * (distance + 1)) / 2
  }

  def part2(input: List[String]): Long = {
    val positions = input.flatMap(line => line.split(",")).map(_.toInt)
    val optimals = optimalPositionPart2(positions)
    val costs = optimals.map( maybeOptimal =>
      positions.map(p => costPart2(Math.abs(p - maybeOptimal))).sum
    )

    costs.min
  }

}
