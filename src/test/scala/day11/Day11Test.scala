package fr.gplassard.adventofcode2021
package day11

import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day11Test extends AnyWordSpec with Matchers {

  "State.next" should {
    "produce 1st step" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day11/sample.txt")).toScala(List).map(_.map(_.toString.toInt).toList)
      val day0 = Day11.State(
        inputs,
        0,
        0
      )
      val day1 = day0.next()

      day1.grid should equal(List(
        List(6, 5, 9, 4, 2, 5, 4, 3, 3, 4),
        List(3, 8, 5, 6, 9, 6, 5, 8, 2, 2),
        List(6, 3, 7, 5, 6, 6, 7, 2, 8, 4),
        List(7, 2, 5, 2, 4, 4, 7, 2, 5, 7),
        List(7, 4, 6, 8, 4, 9, 6, 5, 8, 9),
        List(5, 2, 7, 8, 6, 3, 5, 7, 5, 6),
        List(3, 2, 8, 7, 9, 5, 2, 8, 3, 2),
        List(7, 9, 9, 3, 9, 9, 2, 2, 4, 5),
        List(5, 9, 5, 7, 9, 5, 9, 6, 6, 5),
        List(6, 3, 9, 4, 8, 6, 2, 6, 3, 7),
      ))
    }

    "produce 2nd step" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day11/sample.txt")).toScala(List).map(_.map(_.toString.toInt).toList)
      val day0 = Day11.State(
        inputs,
        0,
        0
      )
      val day2 = day0.next().next()

      day2.grid should equal(List(
        List(8, 8, 0, 7, 4, 7, 6, 5, 5, 5),
        List(5, 0, 8, 9, 0, 8, 7, 0, 5, 4),
        List(8, 5, 9, 7, 8, 8, 9, 6, 0, 8),
        List(8, 4, 8, 5, 7, 6, 9, 6, 0, 0),
        List(8, 7, 0, 0, 9, 0, 8, 8, 0, 0),
        List(6, 6, 0, 0, 0, 8, 8, 9, 8, 9),
        List(6, 8, 0, 0, 0, 0, 5, 9, 4, 3),
        List(0, 0, 0, 0, 0, 0, 7, 4, 5, 6),
        List(9, 0, 0, 0, 0, 0, 0, 8, 7, 6),
        List(8, 7, 0, 0, 0, 0, 6, 8, 4, 8),
      ))
    }
  }

  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day11/sample.txt")).toScala(List)
      Day11.part1(inputs) should equal(1656)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day11/input.txt")).toScala(List)
      Day11.part1(inputs) should equal(1665)
    }
  }

  "part2" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day11/sample.txt")).toScala(List)
      Day11.part2(inputs) should equal(195)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day11/input.txt")).toScala(List)
      Day11.part2(inputs) should equal(235)
    }
  }

}
