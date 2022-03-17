package org.atlassian
package snake

import snake.Game.{Snake, SnakeDirection}

import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.dsl.MatcherWords.be
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should

import scala.util.chaining.*

class GameTest extends AnyFlatSpec with should.Matchers with BeforeAndAfter {

  "Snake game" should "not be over before we even start !!!" in {
    Snake().isGameOver should be(false)
  }

  it should " ot fail if we move 3 times to the right" in {
    Snake()
      .right()
      .right()
      .right()
      .isGameOver should be(false)
  }

  it should "fail if we move 4 times to the right" in {
    Snake()
      .right()
      .right()
      .right()
      .right()
      .isGameOver should be(true)
  }

  it should "not fail if we move 1 times to the left" in {
    Snake()
      .right()
      .left()
      .isGameOver should be(false)
  }

  it should "fail if we move 1 times to the left" in {
    Snake()
      .left()
      .isGameOver should be(true)
  }

  it should "not fail if we move 1 times up" in {
    Snake()
      .down()
      .up()
      .isGameOver should be(false)
  }

  it should "fail if we move 1 times up" in {
    Snake()
      .up()
      .isGameOver should be(true)
  }

  it should "not fail if we move 3 times down" in {
    Snake()
      .down()
      .down()
      .down()
      .isGameOver should be(false)
  }

  it should "fail if we move 4 times down" in {
    Snake()
      .down()
      .down()
      .down()
      .down()
      .isGameOver should be(true)
  }

}