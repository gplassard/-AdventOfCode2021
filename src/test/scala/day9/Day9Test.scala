package fr.gplassard.adventofcode2021
package day9

import day4.Day4.Board
import day6.Day6.{FishesOfAge, State}
import day8.Day8.Line

import fr.gplassard.adventofcode2021.day9.Day9.HeightMap
import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day9Test extends AnyWordSpec with Matchers {

  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day9/sample.txt")).toScala(List)
      Day9.part1(inputs) should equal(15)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day9/input.txt")).toScala(List)
      Day9.part1(inputs) should equal(566)
    }
  }

  "heightmap.findPointsBelongingToBasin " should {
    "find the points for the first lowPoint" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day9/sample.txt")).toScala(List)
      val heightMap = new HeightMap(inputs)
      heightMap.findPointsBelongingToBasin((0, 1)) contains theSameElementsAs(List(
        (0, 0),
        (0, 1),
        (1, 0)
      ))
    }
    "find the points for the second lowPoint" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day9/sample.txt")).toScala(List)
      val heightMap = new HeightMap(inputs)
      heightMap.findPointsBelongingToBasin((0, 9)) contains theSameElementsAs(List(
        (0, 5),
        (0, 6),
        (0, 7),
        (0, 8),
        (0, 9),
        (1, 6),
        (1, 8),
        (1, 9),
        (2, 9),
      ))
    }
  }

  "part2" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day9/sample.txt")).toScala(List)
      Day9.part2(inputs) should equal(1134)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day9/input.txt")).toScala(List)
      Day9.part2(inputs) should equal(891684)
    }
  }

}
