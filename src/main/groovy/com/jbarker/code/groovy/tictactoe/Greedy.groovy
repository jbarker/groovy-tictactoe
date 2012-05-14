package com.jbarker.code.groovy.tictactoe;

import java.util.Map;

/**
 * Simple greedy algorithm for Tic-Tac-Toe.
 */
class Greedy {

    static final Map<Integer, List<Integer>> locationToLines

	final Board board
    final Player opponent
    final Player player

    static {
        locationToLines = [
                    0 : [1, 2, 3, 4, 6, 8], // not: 5, 7
                    1 : [0, 2, 4, 7],
                    2 : [0, 1, 4, 5, 6, 8], // not: 3, 7
                    3 : [0, 4, 5, 6],
                    4 : [0, 1, 2, 3, 5, 6, 7, 8],
                    5 : [2, 3, 4, 8],
                    6 : [0, 2, 3, 4, 7, 8], // not: 1, 5
                    7 : [1, 5, 6, 8],
                    8 : [0, 2, 4, 5, 6, 7], // not: 1, 3
                ]
    }

    /**
     * Constructor for a greedy algorithm to be run on the given board, for the
     * given current player, and the opponent player.
     *
     * @param board the Board
     * @param player the current Player
     * @param opponent the opponent Player
     */
    Greedy(Board board, Player player, Player opponent) {
        this.board = board
        this.player = player
        this.opponent = opponent
    }

    /**
     * Returns the best move as determined by the greedy algorithm.
     *
     * @return an integer, the move location
     */
    int getMove() {
        def result = -1

        // always play a winning move
        for (index in 0..8) {
            if (isWinner(index, player)) {
                result = index
                break
            }
        }

        if (-1 == result) {
            // block a winning move
            for (index in 0..8) {
                if (isWinner(index, opponent)) {
                    result = index
                    break
                }
            }
        }

        if (-1 == result) {
			/*
			 * total desirability score based on lines, occupants
             * adapted from:
			 * http://stackoverflow.com/a/1869148
			 */
            def maxScore = -100
            def maxLocation = -1
            // prefer center, then corners, then sides
            for (location in [4, 0, 2, 6, 8, 1, 3, 5, 7]) {
                if (board.isValidMove(location)) {
                    def score = 0
                    def list = locationToLines.get(location)
                    for (index in list) {
                        def occupant = board.locations[index]
                        if (player.is(occupant)) {
							// occupied by the same player
                            score++
                        } else if (occupant instanceof Player) {
							// occupied by another player
                            score--
                        }
						// else: unoccupied
                    }
                    // strictly greater than, respect preferred location order
                    if (score > maxScore) {
                        maxScore = score
                        maxLocation = location
                    }
                }
            }
            result = maxLocation
        }

        result
    }

    /**
     * Returns true if the given move would be a winning move for the given player.
     *
     * @param index an integer, a move index
     * @param player a Player
     *
     * @return true if the given move would be a winning move for the given player
     */
    private boolean isWinner(int index, Player player) {
        def result = false
        def boardChild = new Board(board)
        if (boardChild.playMove(index, player)) {
            def winner = boardChild.getWinner();
            if (winner == player) {
                result = true
            }
        }
        result
    }

}
