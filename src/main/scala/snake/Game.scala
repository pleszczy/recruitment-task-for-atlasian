package org.atlassian
package snake

import snake.Game.SnakeDirection
import snake.Game.SnakeDirection.{DOWN, LEFT, RIGHT, UP}

object Game {

  enum SnakeDirection:
    case UP, DOWN, LEFT, RIGHT

  class Snake(val x: Int = 1, val y: Int = 1, val noOfMoves: Int = 0, val gameOver: Boolean = false, val previousMove: SnakeDirection = UP) {
    def right() = {
      if (size() > 1 && previousMove == LEFT) {
        Snake(x + 1, y, noOfMoves + 1, gameOver = true, previousMove = RIGHT)

      } else {
        Snake(x + 1, y, noOfMoves + 1, gameOver = isGameOver(x + 1, y), previousMove = RIGHT)
      }
    }

    def left() = {
      if (size() > 1 && previousMove == RIGHT
      )
      {
        Snake(x - 1, y, noOfMoves + 1, gameOver = true, previousMove = LEFT)
      }
      else
      {
        Snake(x - 1, y, noOfMoves + 1, gameOver = isGameOver(x - 1, y), previousMove = LEFT)
      }
    }

    def up(): Snake = {
      if (size() > 1 && previousMove == DOWN) {
        Snake(x, y - 1, noOfMoves + 1, gameOver = true, previousMove = UP)
      } else {
        Snake(x, y - 1, noOfMoves + 1, gameOver = isGameOver(x, y - 1), previousMove = UP)
      }
    }

    def down(): Snake = {
      if (size() > 1 && previousMove == UP) {
        Snake(x, y + 1, noOfMoves + 1, gameOver = true, previousMove = DOWN)
      } else {
        Snake(x, y + 1, noOfMoves + 1, gameOver = isGameOver(x, y + 1), previousMove = DOWN)
      }
    }

    private def isGameOver(nextX: Int, nextY: Int) = {
      gameOver || !(isWithinBoundaries(nextX) && isWithinBoundaries(nextY))
    }

    private def size(): Int = (noOfMoves / 5) + 1

    private def isWithinBoundaries(num: Int) = if (num >= 1 && num <= 4) then true else false

  }
}
