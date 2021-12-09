package fr.gplassard.adventofcode2021
package day9

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day9 {
  def isLowPoint(x: Int, y: Int, input: List[String]): Boolean = {
    val value = input(x).charAt(y)
    val up = if (x != 0) value < input(x - 1).charAt(y) else true
    val down = if (x != input.length - 1) value < input(x + 1).charAt(y) else true
    val left = if (y != 0) value < input(x).charAt(y - 1) else true
    val right = if (y != input(x).length - 1) value < input(x).charAt(y + 1) else true
    up && down && left && right
  }

  def part1(input: List[String]): Long = {
    var risk = 0
    for {
      x <- input.indices
      y <- 0 until input(x).length
    } {
      val value = input(x).charAt(y)
      val lowPoint = isLowPoint(x, y, input)
      if (lowPoint) {
        risk += value.toString.toInt + 1
      }
    }
    risk
  }

}
