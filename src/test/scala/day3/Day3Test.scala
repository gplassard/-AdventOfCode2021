package fr.gplassard.adventofcode2021
package day3

import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day3Test extends AnyWordSpec with Matchers {

  "part1" should {
    "be 0 for empty instructions" in {
      Day3.part1(List.empty) should equal(0)
    }
    "work for a line of 0" in {
      val inputs = List(
        "00000000"
      )
      Day3.part1(inputs) should equal(0)
    }
    "work for a line of 1" in {
      val inputs = List(
        "00000000"
      )
      Day3.part1(inputs) should equal(0)
    }
    "work for a line of 1 and 0" in {
      val inputs = List(
        "11110000"
      )
      val gamma = Integer.parseInt("11110000", 2)
      val epsilon = Integer.parseInt("00001111", 2)
      Day3.part1(inputs) should equal(gamma * epsilon)
    }
    "work for 3 lines of 1 and 0" in {
      val inputs = List(
        "11110000",
        "11110000",
        "11111111",
      )
      val gamma = Integer.parseInt("11110000", 2)
      val epsilon = Integer.parseInt("00001111", 2)
      Day3.part1(inputs) should equal(gamma * epsilon)
    }
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day3/sample.txt")).toScala(List)

      val gamma = 22
      val epsilon = 9
      Day3.part1(inputs) should equal(gamma * epsilon)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day3/input.txt")).toScala(List)

      Day3.part1(inputs) should equal(841526)
    }
  }

}
