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

  case class State(horizontal: Int, depth: Int, aim: Int) {
    def forward(amount: Int): State = this.copy(horizontal = horizontal + amount, depth = depth + (aim * amount))
    def down(amount: Int): State = this.copy(aim = aim + amount)
    def up(amount: Int): State = this.copy(aim = aim - amount)
  }


  def part2(instructions: List[String]): Int = {
    val finalState = instructions
      .foldLeft(State(0, 0, 0))((state, instruction) => instruction match {
        case s"forward ${amount}" => state.forward(amount.toInt)
        case s"down ${amount}" => state.down(amount.toInt)
        case s"up ${amount}" => state.up(amount.toInt)
      })
    finalState.depth * finalState.horizontal
  }

}
