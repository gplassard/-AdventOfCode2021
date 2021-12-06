package fr.gplassard.adventofcode2021
package day6

import day4.Day4.Board

import fr.gplassard.adventofcode2021.day6.Day6.{FishesOfAge, State}
import org.scalatest.*
import org.scalatest.matchers.should.*
import org.scalatest.wordspec.AnyWordSpec

import java.nio.file.{Files, Paths}
import scala.io.Source
import scala.jdk.StreamConverters.*

class Day6Test extends AnyWordSpec with Matchers {

  "FishesOfAge.next" should {
    "decrement days" in {
      FishesOfAge(5, 3).nextDay() should equal(List(FishesOfAge(5, 2)))
    }
    "produce new fishes" in {
      FishesOfAge(5, 0).nextDay() should equal(List(FishesOfAge(5, 6), FishesOfAge(5, 8)))
    }
  }

  "State.next" should {
    "decrement days for one fish group" in {
      State(List(FishesOfAge(5, 3))).next() should equal(State(List(FishesOfAge(5, 2))))
    }
    "decrement days for several fish groups" in {
      State(List(FishesOfAge(5, 3), FishesOfAge(2, 4))).next() should equal(State(List(FishesOfAge(5, 2), FishesOfAge(2, 3))))
    }
    "merge equivalent groups" in {
      State(List(FishesOfAge(5, 3), FishesOfAge(2, 3))).next() should equal(State(List(FishesOfAge(7, 2))))
    }
    "produce new fishes" in {
      State(List(FishesOfAge(5, 0))).next() should equal(State(List(FishesOfAge(5, 6), FishesOfAge(5, 8))))
    }
  }

  "part1" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day6/sample.txt")).toScala(List)
      Day6.part1(inputs) should equal(5934)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day6/input.txt")).toScala(List)
      Day6.part1(inputs) should equal(377263)
    }
  }

  "part2" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day6/sample.txt")).toScala(List)
      Day6.part2(inputs) should equal(26984457539L)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day6/input.txt")).toScala(List)
      Day6.part2(inputs) should equal(1695929023803L)
    }
  }

}
