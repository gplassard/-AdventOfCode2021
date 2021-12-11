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

  def part1(input: List[String]): Long = {
    input.map(illegalChar)
      .collect { case Some(v) => v }
      .map(charScore)
      .sum
  }
}
