package fr.gplassard.adventofcode2021
package day11

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer as MList
import scala.util.control.Breaks.breakable
import scala.util.control.Breaks._

object Day11 {
  type Position = (Int, Int)
  type Size = (Int, Int)
  type Grid = List[List[Int]]

  def size(grid: Grid): Size = (grid.length, grid.head.length)

  def neighbors(position: Position, size: Size): Seq[Position] = {
    val (x, y) = position
    val (sizeX, sizeY) = size
    val neighbors = List(
      (x - 1, y - 1),
      (x - 1, y),
      (x - 1, y + 1),
      (x, y - 1),
      (x, y + 1),
      (x + 1, y - 1),
      (x + 1, y),
      (x + 1, y + 1),
    )
    val valid = neighbors.filter((nx, ny) => nx >= 0 && ny >= 0 && nx < sizeX && ny < sizeY)
    valid
  }

  def makeFlash(grid: Grid, position: Position, alreadyFlashed: Set[Position]): Grid = {
    val mutable = MList.from(grid.map(MList.from))
    mutable(position._1)(position._2) = 0
    neighbors(position, size(grid))
      .filterNot(alreadyFlashed.contains)
      .foreach(neighbor => {
        mutable(neighbor._1)(neighbor._2) = mutable(neighbor._1)(neighbor._2) + 1
      })
    mutable.map(_.toList).toList
  }

  class State(val grid: Grid, val step: Int, val flashCount: Int) {
    val (sizeX, sizeY) = size(grid)

    def next(): State = {
      var flashed = Set.empty[Position]
      var updated = grid.map(line => line.map(value => value + 1))
      var hasChanged = true
      while (hasChanged) {
        hasChanged = false
        for {
          i <- 0 until sizeX
          j <- 0 until sizeY
        } {
          if (updated(i)(j) > 9) {
            if (!flashed.contains((i, j))) {
              flashed = flashed + ((i, j))
              hasChanged = true
              updated = makeFlash(updated, (i, j), flashed)
            }
          }

        }
      }
      State(updated, step + 1, flashCount + flashed.size)
    }
  }

  def part1(input: List[String]): Long = {
    val parsedInput = input.map(_.map(_.toString.toInt).toList)
    val finalState = (0 until 100).foldLeft(new State(parsedInput, 0, 0)) { case (state, index) => state.next() }
    finalState.flashCount
  }
  
  def part2(input: List[String]): Long = {
    val parsedInput = input.map(_.map(_.toString.toInt).toList)
    var fullFlash = false
    var state = new State(parsedInput, 0, 0)
    while (!fullFlash) {
      state = state.next()
      fullFlash = state.grid.forall(_.forall(_ == 0))
    }
    state.step
  }
}
