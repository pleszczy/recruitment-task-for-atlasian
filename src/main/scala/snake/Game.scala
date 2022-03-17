package org.atlassian
package snake

import snake.Game.SnakeDirection
import snake.Game.SnakeDirection.{DOWN, LEFT, RIGHT, UP}

object Game {

  enum SnakeDirection:
    case UP, DOWN, LEFT, RIGHT

  class Snake(val x: Int = 1, val y: Int = 1, val noOfMoves: Int = 0, val size: Int = 1, val gameOver: Boolean = false, val previousMove: SnakeDirection = UP) {
    def right() = {
      Snake(x + 1, y, noOfMoves + 1, noOfMoves / 5, gameOver, previousMove = RIGHT)
    }

    def left() = {
      Snake(x - 1, y, noOfMoves + 1, noOfMoves / 5, gameOver, previousMove = LEFT)
    }

    def up(): Snake = {
      Snake(x, y - 1, noOfMoves + 1, noOfMoves / 5, gameOver, previousMove = UP)
    }

    def down(): Snake = {
      Snake(x, y + 1, noOfMoves + 1, noOfMoves / 5, gameOver, previousMove = DOWN)
    }

    def isGameOver: Boolean = !(isWithinBoundaries(x) && isWithinBoundaries(y))

    private def isWithinBoundaries(num: Int) = if (num >= 1 && num <= 4) then true else false

  }
}
