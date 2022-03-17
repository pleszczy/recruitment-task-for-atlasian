package org.atlassian
package snake

object Game {

  enum SnakeDirection:
    case UP, DOWN, LEFT, RIGHT


  trait SnakeGame {
    def moveSnake(snakeDirection: SnakeDirection, position: Position): Position

    def isGameOver(position: Position): Boolean
  }

  case class Position(x: Int, y: Int, noOfMoves: Int)

  object SnakeGame extends SnakeGame {
    val pollPosition = Position(1, 1, 0)

    override def moveSnake(snakeDirection: SnakeDirection, position: Position): Position =
      snakeDirection match
        case SnakeDirection.UP => Position(position.x, position.y + 1, position.noOfMoves + 1)
        case SnakeDirection.DOWN => Position(position.x, position.y - 1, position.noOfMoves + 1)
        case SnakeDirection.LEFT => Position(position.x - 1, position.y, position.noOfMoves + 1)
        case SnakeDirection.RIGHT => Position(position.x + 1, position.y, position.noOfMoves + 1)


    override def isGameOver(position: Position): Boolean = {
      val xValidation = if position.x >= 1 && position.x <= 4 then true else false
      val yValidation = if position.y >= 1 && position.y <= 4 then true else false
      !(xValidation && yValidation)
    }
  }
}
