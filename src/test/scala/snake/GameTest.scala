package org.atlassian
package snake

import snake.Game.{Position, SnakeDirection, SnakeGame}

import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.dsl.MatcherWords.be
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should

import scala.util.chaining.*

class GameTest extends AnyFlatSpec with should.Matchers with BeforeAndAfter {

  "Snake game" should " not be over before we even start !!!" in {
    SnakeGame.isGameOver(SnakeGame.pollPosition) should be(false)
  }

  it should " not fail if we move 3 times to the right" in {
    val finalPosition = SnakeGame.pollPosition
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)

    SnakeGame.isGameOver(finalPosition) should be(false)
  }

  it should " fail if we move 4 times to the right" in {
    val finalPosition = SnakeGame.pollPosition
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)

    SnakeGame.isGameOver(finalPosition) should be(true)
  }

  it should " fail if we move 5 times to the right" in {
    val finalPosition = SnakeGame.pollPosition
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToRight)

    SnakeGame.isGameOver(finalPosition) should be(true)
  }

  it should " fail if we move 1 times to the left" in {
    val finalPosition = SnakeGame.pollPosition
      .pipe(SnakeGame.moveSnakeToLeft)

    SnakeGame.isGameOver(finalPosition) should be(true)
  }

  it should " not fail if we move 1 times to the left" in {
    val finalPosition = SnakeGame.pollPosition
      .pipe(SnakeGame.moveSnakeToRight)
      .pipe(SnakeGame.moveSnakeToLeft)

    SnakeGame.isGameOver(finalPosition) should be(false)
  }
}