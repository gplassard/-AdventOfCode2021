package fr.gplassard.adventofcode2021
package day4

import scala.annotation.tailrec
import scala.util.control.Breaks._

object Day4 {

  case class Board(lines: List[List[String]]) {
    def addLine(line: String): Board = this.copy(lines = lines :+ line.split(" ").toList.filterNot(_.isBlank))

    def isEmpty: Boolean = lines.isEmpty

    def columns(): List[List[String]] = {
      val length = lines.head.length
      (0 until length).map(index => {
        lines.map(line => line(index))
      }
      ).toList
    }

    def isBingo(numbers: Set[String]): Boolean = {
      val horizontal = lines.exists(line => line.forall(number => numbers.contains(number)))
      val vertical = columns().exists(column => column.forall(number => numbers.contains(number)))
      horizontal || vertical
    }

    def score(numbers: Set[String], lastNumber: String): Int = {
      val unmarked = lines.flatten.filterNot(numbers.contains)
      val sum = unmarked.map(_.toInt).sum
      sum * lastNumber.toInt
    }
  }

  def parseInput(input: List[String]): (List[String], List[Board]) = {
    val numbers = input.head.split(",").toList

    val (boards, finalBoard) = input.tail.foldLeft((List.empty[Board], Board(List.empty))) { case ((completedBoards, board), line) =>
      if (line.isBlank) (completedBoards :+ board, Board(List.empty))
      else (completedBoards, board.addLine(line))
    }
    val allBoards = boards :+ finalBoard

    (numbers, allBoards.filterNot(_.isEmpty))
  }

  def part1(input: List[String]): Int = {
    val (numbers, boards) = parseInput(input)

    var score = 0
    breakable {
      for (length <- numbers.indices) {
        val selectedNumbers = numbers.take(length + 1).toSet
        for (board <- boards) {
          if (board.isBingo(selectedNumbers)) {
            score = board.score(selectedNumbers, numbers(length))
            break
          }
        }
      }
    }
    score
  }

  def part2(input: List[String]): Int = {
    val (numbers, boards) = parseInput(input)

    var score = 0
    var alreadyCompleted = Set.empty[Board]
    for (length <- numbers.indices) {
      val selectedNumbers = numbers.take(length + 1).toSet
      for (board <- boards) {
        if (!alreadyCompleted.contains(board) && board.isBingo(selectedNumbers)) {
          score = board.score(selectedNumbers, numbers(length))
          alreadyCompleted = alreadyCompleted + board
        }
      }
    }
    score
  }

}
