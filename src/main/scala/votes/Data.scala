package org.atlassian
package votes

object Data {
  trait Voting {
    def findWinner(votes: List[RawVote]): List[Candidate]
  }

  object Game extends Voting {
    def findWinner(votes: List[RawVote]): List[Candidate] = {
      votes.flatMap((it: RawVote) => {
        List(3, 2, 1)
          .zip(it.candidates)
          .map(it => Vote(it._2, it._1, 1))
      }).groupBy(v => v.candidate)
        .map(m => m._2.reduce((a, b) => Vote(a.candidate, a.points + b.points, a.noOfVotes + b.noOfVotes)))
        .toList
        .sortBy(it => it.points)(Ordering[Int].reverse)
        .map(it => it.candidate)
    }
  }

}

case class Candidate(name: String)

case class Vote(candidate: Candidate, points: Int, noOfVotes: Int)

case class RawVote(candidates: List[Candidate])
