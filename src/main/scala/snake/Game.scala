package org.atlassian
package snake

import snake.Game.SnakeDirection
import snake.Game.SnakeDirection.{DOWN, LEFT, RIGHT, UP, NONE}

object Game {

  enum SnakeDirection:
    case UP, DOWN, LEFT, RIGHT, NONE

  class Snake(val x: Int = 1, val y: Int = 1, val noOfMoves: Int = 0, val gameOver: Boolean = false, val previousMove: SnakeDirection = NONE, val currentMove: SnakeDirection = NONE) {
    def right() = Snake(x + 1, y, noOfMoves + 1, gameOver, previousMove = currentMove, currentMove = RIGHT)

    def left() = Snake(x - 1, y, noOfMoves + 1, gameOver, previousMove = currentMove, currentMove = LEFT)

    def up(): Snake = Snake(x, y - 1, noOfMoves + 1, gameOver, previousMove = currentMove, currentMove = UP)

    def down(): Snake = Snake(x, y + 1, noOfMoves + 1, gameOver, previousMove = currentMove, currentMove = DOWN)
  }

  object Snake {
    private def size(noOfMoves: Int): Int = (noOfMoves / 5) + 1

    private def isWithinBoundaries(num: Int) = if (num >= 1 && num <= 4) then true else false

    private def isGameOver(nextX: Int, nextY: Int) = !(Snake.isWithinBoundaries(nextX) && Snake.isWithinBoundaries(nextY))

    def apply(x: Int = 1, y: Int = 1, noOfMoves: Int = 0, gameOver: Boolean = false, previousMove: SnakeDirection = NONE, currentMove: SnakeDirection = NONE): Snake = {
      val size = Snake.size(noOfMoves)
      val gameState = calculateGameState(x, y, gameOver, previousMove, currentMove, size)
      new Snake(x, y, noOfMoves, gameState, previousMove, currentMove)
    }

    private def calculateGameState(x: Int, y: Int, gameOver: Boolean, previousMove: SnakeDirection, currentMove: SnakeDirection, size: Int) =
      (previousMove, currentMove) match {
        case (UP, DOWN) if size > 1 => true
        case (DOWN, UP) if size > 1 => true
        case (RIGHT, LEFT) if size > 1 => true
        case (LEFT, RIGHT) if size > 1 => true
        case (_, _) => isGameOver(x, y) || gameOver
      }
  }
}
