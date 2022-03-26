# An online recruitment task for Atlassian

## Task 1

Implement a snake game.
Assume the board is 4x4 for now:
```shell
[x x x x]
[x x x x]
[x x x x]
[x x x x]
```

- snake grows by 1 every 5 moves
- game is over if the snake hits a wall or its tail

### TODO
- the game should be over if the game failed on some previous moves
- refactor test to make creation of tests with longer-sized snakes easier
- add tests for snake of size >= 4

## Task 2

We pass in a list of votes, and we are returned a list of names in the descending order of the score that each candidate
received.

Assume that we extract the candidates' names from the votes as we process them.

A voter is allowed to vote for up to three different candidates. The order of the votes is important. The first vote
that voter places are worth three points. The second vote is worth two points. The third vote is worth one point.

The function should return a list of candidates in descending order of the total number points received by the
candidate.
