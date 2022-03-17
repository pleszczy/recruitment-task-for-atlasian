package org.atlassian
package snake

import snake.Game.SnakeDirection.{DOWN, LEFT, RIGHT, UP}

object Game {

  enum SnakeDirection:
    case UP, DOWN, LEFT, RIGHT


  trait SnakeGame {
    val pollPosition = Position(1, 1, 0)

    def moveSnakeToRight: Position => Position

    def moveSnakeToLeft: Position => Position

    def moveSnakeToUp: Position => Position

    def moveSnakeToDown: Position => Position

    def moveSnake(snakeDirection: SnakeDirection, position: Position): Position

    def isGameOver(position: Position): Boolean
  }

  case class Position(x: Int, y: Int, noOfMoves: Int)

  object SnakeGame extends SnakeGame {
    def moveSnakeToRight: Position => Position = (position: Position) => moveSnake(SnakeDirection.RIGHT, position)

    def moveSnakeToLeft: Position => Position = (position: Position) => moveSnake(SnakeDirection.LEFT, position)

    def moveSnakeToUp: Position => Position = (position: Position) => moveSnake(SnakeDirection.UP, position)

    def moveSnakeToDown: Position => Position = (position: Position) => moveSnake(SnakeDirection.DOWN, position)


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
