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

  "Snake game" should "not be over before snake even move !!!" in {
    Snake().gameOver should be(false)
  }

  it should "not fail if snake moves 3 times to the right" in {
    Snake()
      .right()
      .right()
      .right()
      .gameOver should be(false)
  }

  it should "fail if snake moves 4 times to the right" in {
    Snake()
      .right()
      .right()
      .right()
      .right()
      .gameOver should be(true)
  }

  it should "not fail if snake moves 1 times to the left" in {
    Snake()
      .right()
      .left()
      .gameOver should be(false)
  }

  it should "fail if snake moves 1 times to the left" in {
    Snake()
      .left()
      .gameOver should be(true)
  }

  it should "not fail if snake moves 1 times up" in {
    Snake()
      .down()
      .up()
      .gameOver should be(false)
  }

  it should "fail if snake moves 1 times up" in {
    Snake()
      .up()
      .gameOver should be(true)
  }

  it should "not fail if snake moves 3 times down" in {
    Snake()
      .down()
      .down()
      .down()
      .gameOver should be(false)
  }

  it should "fail if snake moves 4 times down" in {
    Snake()
      .down()
      .down()
      .down()
      .down()
      .gameOver should be(true)
  }

  it should "fail if snakes moves RIGHT and than LEFT while snake size > 1" in {
    Snake(noOfMoves = 5)
      .right()
      .left()
      .gameOver should be(true)
  }

  it should "fail if snakes moves LEFT and than RIGHT while snake size > 1" in {
    Snake(x = 2, noOfMoves = 5)
      .left()
      .right()
      .gameOver should be(true)
  }

  it should "fail if snakes moves UP and than DOWN while snake size > 1" in {
    Snake(y = 2, noOfMoves = 5)
      .up()
      .down()
      .gameOver should be(true)
  }

  it should "fail if snakes moves DOWN and than UP while snake size > 1" in {
    Snake(noOfMoves = 5)
      .down()
      .up()
      .gameOver should be(true)
  }

}