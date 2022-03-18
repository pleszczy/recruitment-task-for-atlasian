package org.atlassian
package snake

import snake.Game.Move.*

import scala.util.chaining.*

object Game {

  enum Move(val x: Int, val y: Int):
    case START extends Move(1, 1)
    case UP extends Move(0, -1)
    case DOWN extends Move(0, 1)
    case LEFT extends Move(-1, 0)
    case RIGHT extends Move(1, 0)

  case class GameBoard(xSize: Int = 4, ySize: Int = 4, moves: Vector[Move] = Vector(START))

  class Snake(board: GameBoard = GameBoard()) {
    def up(): Snake = new Snake(board.copy(moves = board.moves :+ UP))

    def down(): Snake = new Snake(board.copy(moves = board.moves :+ DOWN))

    def left() = new Snake(board.copy(moves = board.moves :+ LEFT))

    def right() = new Snake(board.copy(moves = board.moves :+ RIGHT))

    def isGameOver: Boolean = {
      board
        .moves
        .foldLeft((0, 0))((agg, move) => (agg._1 + move.x, agg._2 + move.y))
        .pipe(isOutsideBoundaries)
    }

    private def isOutsideBoundaries(finalPos: (Int, Int)) = finalPos._1 < 1 || finalPos._1 > board.xSize || finalPos._2 < 1 && finalPos._2 > board.ySize
  }
}
