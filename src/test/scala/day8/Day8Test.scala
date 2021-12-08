package fr.gplassard.adventofcode2021
package day8

import day4.Day4.Board
import day6.Day6.{FishesOfAge, State}

import fr.gplassard.adventofcode2021.day8.Day8.Line
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

  "parseInput" should {
    "correctly parse the first line" in {
      val result = Day8.parseInput(List("be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe"))
      result should equal(List(Line(
        List("be", "abcdefg", "bcdefg", "acdefg", "bceg", "cdefg", "abdefg", "bcdef", "abcdf", "bde"),
        List("abcdefg", "bcdef", "bcdefg", "bceg")
      )))
    }
  }

  "computeSignature" should {
    "compute the signature of a" in {
      Day8.computeSignature('a', Day8.segmentsToDigit.keys.toList) should equal(Map(
        3 -> 1, // a is used 1 time in string of length 3 (7)
        5 -> 3, // a is used 3 times in string of length 5 (2,3,5)
        6 -> 3, // 0,6,9
        7 -> 1, // 8
      ))
    }
    "compute the signature of b" in {
      Day8.computeSignature('b', Day8.segmentsToDigit.keys.toList) should equal(Map(
        4 -> 1, // 4
        5 -> 1, // 5
        6 -> 3, // 0,6,9
        7 -> 1, // 8
      ))
    }
    "compute the signature of c" in {
      Day8.computeSignature('c', Day8.segmentsToDigit.keys.toList) should equal(Map(
        2 -> 1,
        3 -> 1,
        4 -> 1,
        5 -> 2,
        6 -> 2,
        7 -> 1,
      ))
    }
    "compute the signature of d" in {
      Day8.computeSignature('d', Day8.segmentsToDigit.keys.toList) should equal(Map(
        4 -> 1,
        5 -> 3,
        6 -> 2,
        7 -> 1,
      ))
    }
    "compute the signature of e" in {
      Day8.computeSignature('e', Day8.segmentsToDigit.keys.toList) should equal(Map(
        5 -> 1,
        6 -> 2,
        7 -> 1,
      ))
    }
    "compute the signature of f" in {
      Day8.computeSignature('f', Day8.segmentsToDigit.keys.toList) should equal(Map(
        2 -> 1,
        3 -> 1,
        4 -> 1,
        5 -> 2,
        6 -> 3,
        7 -> 1,
      ))
    }
    "compute the signature of g" in {
      Day8.computeSignature('g', Day8.segmentsToDigit.keys.toList) should equal(Map(
        5 -> 3,
        6 -> 3,
        7 -> 1,
      ))
    }
    "be different for each segment" in {
      val signatures = List(
        Day8.computeSignature('a', Day8.segmentsToDigit.keys.toList),
        Day8.computeSignature('b', Day8.segmentsToDigit.keys.toList),
        Day8.computeSignature('c', Day8.segmentsToDigit.keys.toList),
        Day8.computeSignature('d', Day8.segmentsToDigit.keys.toList),
        Day8.computeSignature('e', Day8.segmentsToDigit.keys.toList),
        Day8.computeSignature('f', Day8.segmentsToDigit.keys.toList),
        Day8.computeSignature('g', Day8.segmentsToDigit.keys.toList),
      )
      signatures.toSet.size should equal(7)
    }
  }

  "Line" should {
    "compute the correspondanceMap" in {
      val line = Line(
        List("acedgfb","cdfbe","gcdfa","fbcad","dab","cefabd","cdfgeb","eafb","cagedb","ab"),
        List("cdfeb","fcadb","cdfeb","cdbaf")
      )
      line.correspondanceMap() should equal(Map(
         'd' -> 'a',
         'e' -> 'b',
         'a' -> 'c',
         'f' -> 'd',
         'g' -> 'e',
         'b' -> 'f',
         'c' -> 'g',
      ))
    }
    "solve first line" in {
      val line = Line(
        List("be", "abcdefg", "bcdefg", "acdefg", "bceg", "cdefg", "abdefg", "bcdef", "abcdf", "bde"),
        List("abcdefg", "bcdef", "bcdefg", "bceg")
      )
      line.solve() should equal(8394)
    }
  }

  "part2" should {
    "work for sample" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day8/sample.txt")).toScala(List)
      Day8.part2(inputs) should equal(61229)
    }
    "work for input" in {
      val inputs = Files.lines(Paths.get("src/test/resources/day8/input.txt")).toScala(List)
      Day8.part2(inputs) should equal(1020159)
    }
  }

}
