package fr.gplassard.adventofcode2021
package day9

import scala.annotation.tailrec
import scala.util.control.Breaks.*

object Day9 {
  type Point = (Int, Int)

  class HeightMap(input: List[String]) {
    val sizeX: Int = input.length
    val sizeY: Int = input.head.length

    def valueAt(point: Point): Int = {
      val (x, y) = point
      input(x).charAt(y).toString.toInt
    }

    def neighbors(point: Point): Seq[Point] = {
      val (x, y) = point
      val up = if (x != 0) Seq((x - 1, y)) else Seq.empty
      val down = if (x != sizeX - 1) Seq((x + 1, y)) else Seq.empty
      val left = if (y != 0) Seq((x, y - 1)) else Seq.empty
      val right = if (y != sizeY - 1) Seq((x, y + 1)) else Seq.empty
      up ++ down ++ left ++ right
    }

    def isLowPoint(point: Point): Boolean = {
      neighbors(point).forall(neighbor => valueAt(point) < valueAt(neighbor))
    }

    def findPointsBelongingToBasin(lowpoint: (Int, Int)): Seq[Point] = {
      var points = Set.empty[Point]
      var visited = Set.empty[Point]
      val toVisit = scala.collection.mutable.ListBuffer(lowpoint)

      while (toVisit.nonEmpty) {
        val element = toVisit.remove(0)
        val value = input(element._1).charAt(element._2)
        visited = visited + element
        points = points + element
        for (neighbor <- neighbors(element)) {
          val valid = valueAt(neighbor) != 9 && valueAt(neighbor) > valueAt(element)
          if (valid && !visited.contains(neighbor)) {
            toVisit.addOne(neighbor)
          }
        }
      }
      points.toSeq
    }

  }

  def part1(input: List[String]): Long = {
    val heightMap = new HeightMap(input)
    var risk = 0
    for {
      x <- input.indices
      y <- 0 until input(x).length
    } {
      val lowPoint = heightMap.isLowPoint((x, y))
      if (lowPoint) {
        risk += heightMap.valueAt(x, y) + 1
      }
    }
    risk
  }

  def part2(input: List[String]): Long = {
    val heightMap = new HeightMap(input)

    val basins = for {
      x <- input.indices
      y <- 0 until input(x).length
      if heightMap.isLowPoint((x, y))
    } yield heightMap.findPointsBelongingToBasin((x, y))

    basins.map(_.length).sorted.reverse.take(3).product
  }

}
