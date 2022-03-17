package org.atlassian
package snake

import snake.Game.{Position, SnakeDirection, SnakeGame}
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should

import scala.util.chaining.*

class GameTest extends AnyFlatSpec with should.Matchers with BeforeAndAfter {

  "Snake game" should " not be over before we even start !!!" in {
    SnakeGame.isGameOver(SnakeGame.pollPosition) should be(false)
  }

  "Snake game" should " fail if we move 4 times to the right" in {
    val a = SnakeGame.moveSnake(SnakeDirection.RIGHT, SnakeGame.pollPosition)
    val b = SnakeGame.moveSnake(SnakeDirection.RIGHT, a)
    val c = SnakeGame.moveSnake(SnakeDirection.RIGHT, b)
    val finalPosition = SnakeGame.moveSnake(SnakeDirection.RIGHT, c)

    SnakeGame.isGameOver(finalPosition) should be(true)
  }


  "Snake game" should " not fail if we move 3 times to the right" in {
    val a = SnakeGame.moveSnake(SnakeDirection.RIGHT, SnakeGame.pollPosition)
    val b = SnakeGame.moveSnake(SnakeDirection.RIGHT, a)
    val finalPosition = SnakeGame.moveSnake(SnakeDirection.RIGHT, b)

    SnakeGame.isGameOver(finalPosition) should be(false)
  }


  "Snake game" should " fail if we move 5 times to the right" in {
    val a = SnakeGame.moveSnake(SnakeDirection.RIGHT, SnakeGame.pollPosition)
    val b = SnakeGame.moveSnake(SnakeDirection.RIGHT, a)
    val c = SnakeGame.moveSnake(SnakeDirection.RIGHT, b)
    val d = SnakeGame.moveSnake(SnakeDirection.RIGHT, c)
    val finalPosition = SnakeGame.moveSnake(SnakeDirection.RIGHT, d)

    SnakeGame.isGameOver(finalPosition) should be(true)
  }
}