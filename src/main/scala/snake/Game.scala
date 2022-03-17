package org.atlassian
package snake

import snake.Game.SnakeDirection
import snake.Game.SnakeDirection.{DOWN, LEFT, RIGHT, UP}

object Game {

  enum SnakeDirection:
    case UP, DOWN, LEFT, RIGHT


  trait SnakeGame {
    def moveSnakeRight: Position => Position

    def moveSnakeLeft: Position => Position

    def moveSnakeUp: Position => Position

    def moveSnakeDown: Position => Position

    def moveSnake(snakeDirection: SnakeDirection, position: Position): Position

    def isGameOver(position: Position): Boolean
  }

  case class Position(x: Int, y: Int, noOfMoves: Int)

  object SnakeGame extends SnakeGame {
    val pollPosition = Position(1, 1, 0)

    override def moveSnakeRight = position => moveSnake(RIGHT, position)

    override def moveSnakeLeft = (position: Position) => moveSnake(LEFT, position)

    override def moveSnakeUp = (position: Position) => moveSnake(UP, position)

    override def moveSnakeDown = (position: Position) => moveSnake(DOWN, position)

    override def moveSnake(snakeDirection: SnakeDirection, position: Position): Position =
      snakeDirection match
        case UP => Position(position.x, position.y + 1, position.noOfMoves + 1)
        case DOWN => Position(position.x, position.y - 1, position.noOfMoves + 1)
        case LEFT => Position(position.x - 1, position.y, position.noOfMoves + 1)
        case RIGHT => Position(position.x + 1, position.y, position.noOfMoves + 1)


    override def isGameOver(position: Position): Boolean =
      !(isWithinBoundaries(position.x) && isWithinBoundaries(position.y))

    private def isWithinBoundaries(num: Int) = if num >= 1 && num <= 4 then true else false
  }
}
