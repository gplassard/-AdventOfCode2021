package fr.gplassard.adventofcode2021
package day8

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day8 {
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


}
