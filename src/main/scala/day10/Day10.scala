package fr.gplassard.adventofcode2021
package day10

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day10 {
  def charScore(char: Char): Int = {
    char match {
      case ')' => 3
      case ']' => 57
      case '}' => 1197
      case '>' => 25137
    }
  }

  def isMatchingPair(start: Char, end: Char): Boolean = {
    val p1 = start == '(' && end == ')'
    val p2 = start == '{' && end == '}'
    val p3 = start == '[' && end == ']'
    val p4 = start == '<' && end == '>'
    p1 || p2 || p3 || p4
  }

  def getMatchingClosingPair(start: Char): Char = {
    start match {
      case '(' => ')'
      case '[' => ']'
      case '{' => '}'
      case '<' => '>'
    }
  }

  def illegalChar(line: String): Option[Char] = {
    val chars = scala.collection.mutable.ListBuffer(line.toList).flatten
    val stack = scala.collection.mutable.ListBuffer.empty[Char]
    val startChars = Set('(', '{', '[', '<')
    while (chars.nonEmpty) {
      val char = chars.remove(0)
      if (startChars.contains(char)) {
        stack.prepend(char)
      }
      else {
        val head = stack.remove(0)
        if (!isMatchingPair(head, char)) {
          return Some(char)
        }
      }
    }
    None
  }

  def completingCharacters(line: String): List[Char] = {
    val chars = scala.collection.mutable.ListBuffer(line.toList).flatten
    val stack = scala.collection.mutable.ListBuffer.empty[Char]
    val startChars = Set('(', '{', '[', '<')
    var counter = 0
    while (chars.nonEmpty) {
      counter = counter + 1
      val char = chars.remove(0)
      if (startChars.contains(char)) {
        stack.prepend(char)
      }
      else {
        stack.remove(0)
      }
    }
    stack.map(getMatchingClosingPair).toList
  }

  def part1(input: List[String]): Long = {
    input.map(illegalChar)
      .collect { case Some(v) => v }
      .map(charScore)
      .sum
  }

  def charScorePart2(char: Char): Int = {
    char match {
      case ')' => 1
      case ']' => 2
      case '}' => 3
      case '>' => 4
    }
  }

  def part2Score(chars: List[Char]): Long = {
    chars.foldLeft(0L)((score, char) => score * 5 + charScorePart2(char))
  }

  def part2(input: List[String]): Long = {
    val scores = input
      .filter(line => illegalChar(line).isEmpty)
      .map(completingCharacters)
      .map(part2Score)
      .sorted
    scores(scores.length / 2)
  }
}
