package org.atlassian
package votes

import org.scalatest.BeforeAndAfter
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should

import scala.Console.in

class DataTest extends AnyFlatSpec with should.Matchers with BeforeAndAfter {
  "Piotr" should " win the vote" in {
    val candidates = List(Candidate("Piotr"), Candidate("Jana"), Candidate("Krzysztofa"))
    val rawVotes = List(RawVote(candidates))
    Data.Game.findWinner(rawVotes).head should be(Candidate("Piotr"))
  }

  "Piotr" should "not win the vote" in {
    val voteA = RawVote(List(Candidate("Piotr"), Candidate("Jan"), Candidate("Krzysztof")))
    val voteB = RawVote(List(Candidate("Jan"), Candidate("Krzysztof"), Candidate("Piotr")))
    val rawVotes = List(voteA, voteB)
    Data.Game.findWinner(rawVotes) should be(List(Candidate("Jan"), Candidate("Piotr"), Candidate("Krzysztof")))
  }

  "game" should "work when only 2 names were given" in {
    val voteA = RawVote(List(Candidate("Jan"), Candidate("Piotr")))
    val voteB = RawVote(List(Candidate("Krzysztof")))
    val rawVotes = List(voteA, voteB)
    Data.Game.findWinner(rawVotes) should be(List(Candidate("Jan"),Candidate("Krzysztof"), Candidate("Piotr")))
  }
}
