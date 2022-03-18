package org.atlassian
package snake

import snake.Game.Move

import scala.math.BigDecimal.RoundingMode.UP
import scala.util.chaining.*

object Game {

  case class Move(x: Int, y: Int)

  def UP = Move(0, -1)

  def DOWN = Move(0, 1)

  def LEFT = Move(-1, 0)

  def RIGHT = Move(1, 0)

  def START = Move(1, 1)

  case class GameBoard(xSize: Int = 4, ySize: Int = 4, moves: Vector[Move] = Vector(START))

  class Snake(board: GameBoard = GameBoard()) {
    def up(): Snake = new Snake(board.copy(moves = board.moves :+ UP))

    def down(): Snake = new Snake(board.copy(moves = board.moves :+ DOWN))

    def left() = new Snake(board.copy(moves = board.moves :+ LEFT))

    def right() = new Snake(board.copy(moves = board.moves :+ RIGHT))

    def isGameOver: Boolean = board
      .moves
      .reduce((m1, m2) => Move(m1.x + m2.x, m1.y + m2.y))
      .pipe(isOutsideBoundaries)

    private def isOutsideBoundaries(finalPos: Move) = finalPos.x < 1 || finalPos.x > board.xSize || finalPos.y < 1 && finalPos.y > board.ySize
  }
}
