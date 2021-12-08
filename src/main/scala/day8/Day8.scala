package fr.gplassard.adventofcode2021
package day8

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day8 {
  val segmentsToDigit: Map[String, Int] = Map(
     "abcefg" -> 0,
     "cf" -> 1,
     "acdeg" -> 2,
     "acdfg" -> 3,
     "bcdf" -> 4,
     "abdfg" -> 5,
     "abdefg" -> 6,
     "acf" -> 7,
     "abcdefg" -> 8,
     "abcdfg" -> 9,
  )

  val signatureMap: Map[Signature, Char] = ('a' to 'g').map(c => (computeSignature(c, segmentsToDigit.keys.toList), c)).toMap

  extension (a: String => Boolean)
    infix def or(b: String => Boolean): String => Boolean = {
      arg => a(arg) || b(arg)
    }

  def part1(input: List[String]): Long = {
    val outputs = input.map(i => i.split("\\|")(1)).flatMap(_.split(" "))
    val is1: String => Boolean = _.length == 2
    val is4: String => Boolean = _.length == 4
    val is7: String => Boolean = _.length == 3
    val is8: String => Boolean = _.length == 7

    outputs.count(is1 or is4 or is7 or is8)
  }

  case class Line(observations: List[String], output: List[String]) {
    def correspondanceMap(): Map[Char, Char] = {
      val observationSignatures = ('a' to 'g').map(segment => (segment, computeSignature(segment, observations))).toMap
      ('a' to 'g')
        .map(char => char -> observationSignatures(char))
        .toMap
        .view
        .mapValues(signatureMap.apply)
        .toMap
    }

    def solve(): Int = {
      val mapping = correspondanceMap()
      val number = output
        .map(chars => chars.map(mapping.apply).sorted.mkString(""))
        .map(translatedSegments => segmentsToDigit(translatedSegments).toString)
        .mkString("")
      number.toInt
    }
  }

  // signature : Map(l -> c) counting the number of segments c of length l in which the segment is present
  type Signature = Map[Int, Int]

  def computeSignature(segment: Char, observations: List[String]): Signature = {
    observations
      .filter(_.contains(segment))
      .foldLeft(Map.empty[Int, Int]) { case (acc, segments) =>
        val length = segments.length
        val updatedCount = acc.getOrElse(segments.length, 0) + 1
        acc + (length -> updatedCount)
      }
  }

  def part2(input: List[String]): Long = {
    val lines = parseInput(input)
    lines.map(_.solve()).sum
  }


  def parseInput(input: List[String]): List[Line] = {
    input.map(i => {
      val splitted = i.split("\\|")
      Line(
        splitted(0).split(" ").map(_.sorted).toList.filter(_.nonEmpty),
        splitted(1).split(" ").map(_.sorted).toList.filter(_.nonEmpty)
      )
    })
  }
}
