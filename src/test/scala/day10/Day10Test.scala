package fr.gplassard.adventofcode2021
package day10

import day4.Day4.Board
import day6.Day6.{FishesOfAge, State}
import day8.Day8.Line
import day9.Day9.HeightMap

import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day10Test extends AnyWordSpec with Matchers {

  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day10/sample.txt")).toScala(List)
      Day10.part1(inputs) should equal(26397)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day10/input.txt")).toScala(List)
      Day10.part1(inputs) should equal(294195)
    }
  }

}
