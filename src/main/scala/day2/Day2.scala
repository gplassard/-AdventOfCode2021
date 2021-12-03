package fr.gplassard.adventofcode2021
package day2

object Day2 {
  case class Position(horizontal: Int, depth: Int) {
    def forward(amount: Int): Position = this.copy(horizontal = horizontal + amount)
    def down(amount: Int): Position = this.copy(depth = depth + amount)
    def up(amount: Int): Position = this.copy(depth = depth - amount)
  }

  def part1(instructions: List[String]): Int = {
    val finalPosition = instructions
      .foldLeft(Position(0,0))((position, instruction) => instruction match {
        case s"forward ${amount}" => position.forward(amount.toInt)
        case s"down ${amount}" => position.down(amount.toInt)
        case s"up ${amount}" => position.up(amount.toInt)
      })
    finalPosition.depth * finalPosition.horizontal
  }

}
