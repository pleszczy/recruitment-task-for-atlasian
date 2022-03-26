package org.atlassian
package snake

import snake.Game.Move.*

import scala.util.chaining.*

object Game {

  case class Position(x: Int, y: Int)

  case class BoardSize(x: Int, y: Int)

  object Position {
    def apply(position: Position, move: Move): Position =
      Position(position.x + move.x, position.y + move.y)

    def apply(position: Position, moves: Vector[Move]): Position =
      moves.foldLeft(position) {
        (position, move) => Position(position, move)
      }
  }

  def DEFAULT_START_POSITION = Position(1, 1)

  def DEFAULT_BOARD_SIZE = BoardSize(4, 4)

  def CLEAN_BOARD = GameBoard(DEFAULT_BOARD_SIZE, Vector(DEFAULT_START_POSITION))

  enum Move(val x: Int, val y: Int):
    case UP extends Move(0, -1)
    case DOWN extends Move(0, 1)
    case LEFT extends Move(-1, 0)
    case RIGHT extends Move(1, 0)

  case class GameBoard(boardSize: BoardSize, positions: Vector[Position])

  object GameBoard {
    def apply(boardSize: BoardSize, startPosition: Position, moves: Vector[Move]): GameBoard = {
      var pointer = startPosition
      val positions: Vector[Position] = moves.map(move => {
        val position = Position(pointer.x + move.x, pointer.y + move.y)
        pointer = position
        position
      })
      GameBoard(boardSize, positions)
    }
  }

  case class Snake(board: GameBoard) {
    def up(): Snake = move(board, Option(UP))

    def down(): Snake = move(board, Option(DOWN))

    def left() = move(board, Option(LEFT))

    def right() = move(board, Option(RIGHT))

    def move(board: GameBoard, move: Option[Move]): Snake = {
      move
        .map(move => {
          val positionsUpdated = board.positions :+ Position(board.positions.last, move)
          GameBoard(board.boardSize, positionsUpdated)
        })
      .match {
        case Some(board) => Snake(board)
        case None => Snake(board)
      }
    }

    def isASuicidedMove(board: GameBoard): Boolean = {
      val positions = board.positions
      val snakeSize = positions.size / 5 + 1
      val positionsOccupiedBySnake = positions.drop(positions.size - snakeSize - 1)
      positionsOccupiedBySnake.toSet.size != positionsOccupiedBySnake.size
    }

    def isGameOver: Boolean = isOutsideBoundaries(board.positions.last) || isASuicidedMove(board)

    private def isOutsideBoundaries(position: Position) = position.x < 1 || position.x > board.boardSize.x || position.y < 1 || position.y > board.boardSize.y
  }
}
