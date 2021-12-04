package fr.gplassard.adventofcode2021
package day4

import day4.Day4.Board

import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day4Test extends AnyWordSpec with Matchers {

  "parseInput" should {
    "correctly parse single board input" in {
      val (numbers, boards) = Day4.parseInput(List(
        "1,2,3,4",
        "",
        "1 2 3",
        "4 5 6",
      ))

      numbers should equal(List("1", "2", "3", "4"))
      boards should equal(List(
        Board(List(
          List("1", "2", "3"),
          List("4", "5", "6"),
        ))
      ))
    }

    "correctly parse multiple board input" in {
      val (numbers, boards) = Day4.parseInput(List(
        "1,2,3,4",
        "",
        "1 2 3",
        "4 5 6",
        "",
        "7 8 9",
        "10 11 12",
      ))

      numbers should equal(List("1", "2", "3", "4"))
      boards should equal(List(
        Board(List(
          List("1", "2", "3"),
          List("4", "5", "6"),
        )),
        Board(List(
          List("7", "8", "9"),
          List("10", "11", "12"),
        ))
      ))
    }
  }

  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day4/sample.txt")).toScala(List)
      Day4.part1(inputs) should equal(4512)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day4/input.txt")).toScala(List)
      Day4.part1(inputs) should equal(35670)
    }
  }

}
