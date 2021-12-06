package fr.gplassard.adventofcode2021
package day6

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day6 {
  case class FishesOfAge(count: Long, daysUntilCreation: Int) {
    def nextDay(): List[FishesOfAge] = {
      if (daysUntilCreation == 0) List(FishesOfAge(this.count, 6), FishesOfAge(this.count, 8))
      else List(FishesOfAge(this.count, this.daysUntilCreation - 1))
    }
  }
  case class State(fishes: List[FishesOfAge]) {
    def next(): State = {
      val f = fishes.flatMap(f => f.nextDay())
        .groupBy(_.daysUntilCreation)
        .map{case (daysUntilCreation, fishesOfAges) => FishesOfAge(fishesOfAges.map(_.count).sum, daysUntilCreation)}

      State(f.toList)
    }
  }

  def part1(input: List[String]): Long = {
    val fishes = input.flatMap(_.split(",").map(_.toInt))
    val startState = fishes.groupBy(Predef.identity).map{case (daysUntilCreation, items) => FishesOfAge(items.length, daysUntilCreation)}

    val finalState = (1 to 80)
      .foldLeft(State(startState.toList)) { case (state, day) =>
        state.next()
      }

    val result = finalState.fishes.map(_.count).sum
    result
  }

  def part2(input: List[String]): Long = {
    val fishes = input.flatMap(_.split(",").map(_.toInt))
    val startState = fishes.groupBy(Predef.identity).map{case (daysUntilCreation, items) => FishesOfAge(items.length, daysUntilCreation)}

    val finalState = (1 to 256)
      .foldLeft(State(startState.toList)) { case (state, day) =>
        state.next()
      }

    val result = finalState.fishes.map(_.count).sum
    result
  }

}
