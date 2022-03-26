package org.atlassian
package snake

import snake.Game.{Move, *}

import org.atlassian.snake.Game.Move.*
import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.dsl.MatcherWords.be
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should

import scala.util.chaining.*

class GameTest extends AnyFlatSpec with should.Matchers with BeforeAndAfter {

  "Snake game" should "not be over before it even begin !!!" in {
    Snake(CLEAN_BOARD).isGameOver should be(false)
  }

  it should "not fail if snake moves 3 times to the right" in {
    Snake(CLEAN_BOARD)
      .right()
      .right()
      .right()
      .isGameOver should be(false)
  }

  it should "fail if snake moves 4 times to the right" in {
    Snake(CLEAN_BOARD)
      .right()
      .right()
      .right()
      .right()
      .isGameOver should be(true)
  }

  it should "not fail if snake moves 1 times to the left" in {
    Snake(CLEAN_BOARD)
      .right()
      .left()
      .isGameOver should be(false)
  }

  it should "fail if snake moves 1 times to the left" in {
    Snake(CLEAN_BOARD)
      .left()
      .isGameOver should be(true)
  }

  it should "not fail if snake moves 1 times up" in {
    Snake(CLEAN_BOARD)
      .down()
      .up()
      .isGameOver should be(false)
  }

  it should "fail if snake moves 1 times up" in {
    Snake(CLEAN_BOARD)
      .up()
      .isGameOver should be(true)
  }

  it should "not fail if snake moves 3 times down" in {
    Snake(CLEAN_BOARD)
      .down()
      .down()
      .down()
      .isGameOver should be(false)
  }

  it should "fail if snake moves 4 times down" in {
    Snake(CLEAN_BOARD)
      .down()
      .down()
      .down()
      .down()
      .isGameOver should be(true)
  }

   it should "fail if snakes moves RIGHT and than LEFT while snake size > 1" in {
    Snake(GameBoard(DEFAULT_BOARD_SIZE, DEFAULT_START_POSITION, Vector(RIGHT, RIGHT, DOWN)))
      .left()
      .right()
      .isGameOver should be(true)
  }

  it should "fail if snakes moves LEFT and than RIGHT while snake size > 1" in {
    Snake(GameBoard(DEFAULT_BOARD_SIZE, DEFAULT_START_POSITION, Vector(LEFT, RIGHT, LEFT, RIGHT, LEFT, RIGHT)))
      .left()
      .right()
      .isGameOver should be(true)
  }

  it should "fail if snakes moves UP and than DOWN while snake size > 1" in {
    Snake(GameBoard(DEFAULT_BOARD_SIZE, DEFAULT_START_POSITION, Vector(LEFT, RIGHT, LEFT, RIGHT, LEFT, RIGHT)))
      .up()
      .down()
      .isGameOver should be(true)
  }

  it should "fail if snakes moves DOWN and than UP while snake size > 1" in {
    Snake(GameBoard(DEFAULT_BOARD_SIZE, DEFAULT_START_POSITION, Vector(LEFT, RIGHT, LEFT, RIGHT, LEFT, RIGHT)))
      .down()
      .up()
      .isGameOver should be(true)
  }
}