package fr.gplassard.adventofcode2021
package day5

import scala.annotation.tailrec
import scala.util.control.Breaks._

object Day5 {
  case class Point(x: Int, y: Int)

  def collinear(a: Point, b: Point, c: Point): Boolean =
    (b.x - a.x) * (c.y - a.y) == (c.x - a.x) * (b.y - a.y)

  def within(p: Int, q: Int, r: Int): Boolean =
    (p <= q && q <= r) || (r <= q && q <= p)

  case class Line(start: Point, end: Point) {
    def includes(point: Point): Boolean = {
      val horizontal = start.x == point.x && point.x == end.x && within(start.y, point.y, end.y)
      val vertical = start.y == point.y && point.y == end.y && within(start.x, point.x, end.x)
      horizontal || vertical
    }

    def includesWithDiagonals(point: Point): Boolean = {
      collinear(start, end, point) && (if (start.x != end.x) within(start.x, point.x, end.x) else within(start.y, point.y, end.y))
    }
  }

  private def parseInput(input: List[String]) = {
    input.map(line => {
      val splitted = line.split(" -> ")
      val start = splitted(0).split(",")
      val end = splitted(1).split(",")
      Line(
        Point(start(0).toInt, start(1).toInt),
        Point(end(0).toInt, end(1).toInt),
      )
    })
  }

  def part1(input: List[String]): Int = {
    val lines = parseInput(input)
    val maxX = Math.max(lines.map(_.start.x).max, lines.map(_.end.x).max)
    val maxY = Math.max(lines.map(_.start.y).max, lines.map(_.end.y).max)

    val points = for {
      x <- 0 to maxX
      y <- 0 to maxY
    } yield lines.count(_.includes(Point(x, y)))

    val result = points.count(_ >= 2)
    result
  }

  def part2(input: List[String]): Int = {
    val lines = parseInput(input)
    val maxX = Math.max(lines.map(_.start.x).max, lines.map(_.end.x).max)
    val maxY = Math.max(lines.map(_.start.y).max, lines.map(_.end.y).max)

    val points = for {
      x <- 0 to maxX
      y <- 0 to maxY
    } yield lines.count(_.includesWithDiagonals(Point(x, y)))

    val result = points.count(_ >= 2)
    result
  }

}
