package fr.gplassard.adventofcode2021
package day8

import day4.Day4.Board
import day6.Day6.{FishesOfAge, State}

import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day8Test extends AnyWordSpec with Matchers {


  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day8/sample.txt")).toScala(List)
      Day8.part1(inputs) should equal(26)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day8/input.txt")).toScala(List)
      Day8.part1(inputs) should equal(362)
    }
  }

}
