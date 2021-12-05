package fr.gplassard.adventofcode2021
package day5

import day4.Day4.Board

import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day5Test extends AnyWordSpec with Matchers {

  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day5/sample.txt")).toScala(List)
      Day5.part1(inputs) should equal(5)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day5/input.txt")).toScala(List)
      Day5.part1(inputs) should equal(4728)
    }
  }

  "part2" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day5/sample.txt")).toScala(List)
      Day5.part2(inputs) should equal(12)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day5/input.txt")).toScala(List)
      Day5.part2(inputs) should equal(17717)
    }
  }


}
