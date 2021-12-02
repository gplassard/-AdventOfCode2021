package fr.gplassard.adventofcode2021
package day1

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.*
import matchers.should.*

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters._

class Day1Test extends AnyWordSpec with Matchers {

  "part1" should {
    "be 0 for empty measurements" in {
      Day1.part1(List.empty) should equal(0)
    }

    "be 0 for single measurements" in {
      Day1.part1(List(12)) should equal(0)
    }

    "be 0 for decreasing measurements" in {
      Day1.part1(List(12, 11, 10)) should equal(0)
    }

    "count the number of increases" in {
      Day1.part1(List(10, 11, 9, 13, 12)) should equal(2)
    }

    "work for the sample" in {
      val measures = Files.lines(Paths.get("src/test/resources/day1/sample.txt")).map(l => Integer.parseInt(l)).toScala(List)
      Day1.part1(measures) should equal(7)
    }

    "work for the input" in {
      val measures = Files.lines(Paths.get("src/test/resources/day1/input.txt")).map(l => Integer.parseInt(l)).toScala(List)
      Day1.part1(measures) should equal(1298)
    }
  }

  "part2" should {
    "be 0 for empty measurements" in {
      Day1.part2(List.empty) should equal(0)
    }

    "be 0 for 3 measurements" in {
      Day1.part2(List(1, 2, 3)) should equal(0)
    }

    "be 1 for increased measurements" in {
      Day1.part2(List(1, 2, 3 ,4)) should equal(1)
    }

    "be 0 for decreased measurements" in {
      Day1.part2(List(1, 2, 3 , 0)) should equal(0)
    }

    "work for the sample" in {
      val measures = Files.lines(Paths.get("src/test/resources/day1/sample.txt")).map(l => Integer.parseInt(l)).toScala(List)
      Day1.part2(measures) should equal(5)
    }

    "work for the input" in {
      val measures = Files.lines(Paths.get("src/test/resources/day1/input.txt")).map(l => Integer.parseInt(l)).toScala(List)
      Day1.part2(measures) should equal(1248)
    }
  }

}
