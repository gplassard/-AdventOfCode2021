package fr.gplassard.adventofcode2021
package day2

import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day2Test extends AnyWordSpec with Matchers {

  "part1" should {
    "be 0 for empty instructions" in {
      Day2.part1(List.empty) should equal(0)
    }

    "be 0 for single move" in {
      Day2.part1(List("up 3")) should equal(0)
    }

    "work for multi instructions" in {
      Day2.part1(List("up 2", "down 3", "forward 7")) should equal(7)
    }

    "work for the sample" in {
      val instructions = Files.lines(Paths.get("src/test/resources/day2/sample.txt")).toScala(List)
      Day2.part1(instructions) should equal(150)
    }

    "work for the input" in {
      val instructions = Files.lines(Paths.get("src/test/resources/day2/input.txt")).toScala(List)
      Day2.part1(instructions) should equal(1654760)
    }
  }

  "part2" should {
    "be 0 for empty instructions" in {
      Day2.part2(List.empty) should equal(0)
    }

    "be 0 for single move" in {
      Day2.part2(List("up 3")) should equal(0)
    }

    "work for multi instructions" in {
      Day2.part2(List("up 2", "down 3", "forward 7")) should equal(49)
    }

    "work for the sample" in {
      val instructions = Files.lines(Paths.get("src/test/resources/day2/sample.txt")).toScala(List)
      Day2.part2(instructions) should equal(900)
    }

    "work for the input" in {
      val instructions = Files.lines(Paths.get("src/test/resources/day2/input.txt")).toScala(List)
      Day2.part2(instructions) should equal(1956047400)
    }
  }

}
