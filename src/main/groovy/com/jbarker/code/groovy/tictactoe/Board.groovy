package com.jbarker.code.groovy.tictactoe;

/**
 * Game board for Tic-Tac-Toe.
 */
class Board {

    /**
     * Indicates an empty, playable location on the game board.
     */
    private static Object BLANK = " ";

    /**
     * The initial game board locations are all empty.
     */
    private Object[] locations = [
        BLANK,
        BLANK,
        BLANK,
        BLANK,
        BLANK,
        BLANK,
        BLANK,
        BLANK,
        BLANK
    ]

    /**
     * Default constructor.
     */
    Board() {
        super()
    }

    /**
     * Copy constructor.
     *
     * @param board
     */
    Board(Board board) {
        this()
        this.locations = board.locations.clone()
    }

    /**
     * Returns the number of remaining valid moves.
     *
     * @return an integer, the number of remaining valid moves
     */
    int getValidMoveCount() {
        def count = 0
        for (index in 0..8) {
            if (isValidMove(index)) {
                count++
            }
        }
        count
    }

    /**
     * Returns the marker of the winning player.
     *
     * @return a Player, the winning player
     */
    Player getWinner() {
        if (isAllAlike(0, 1, 2)) return locations[0]
        if (isAllAlike(3, 4, 5)) return locations[3]
        if (isAllAlike(6, 7, 8)) return locations[6]
        if (isAllAlike(0, 3, 6)) return locations[0]
        if (isAllAlike(1, 4, 7)) return locations[1]
        if (isAllAlike(2, 5, 8)) return locations[2]
        if (isAllAlike(0, 4, 8)) return locations[0]
        if (isAllAlike(6, 4, 2)) return locations[6]
        return null
    }

    /**
     * Returns true if all provided locations are alike.
     *
     * Empty locations are not considered alike.
     *
     * @param i an integer, an index to a board location
     * @param j an integer, an index to a board location
     * @param k an integer, an index to a board location
     *
     * @return true if all provided locations are alike.
     */
    private boolean isAllAlike(int i, int j, int k) {
        def result = (!isValidMove(i)) &&
            (locations[i] == locations[j]) &&
            (locations[j] == locations[k]) &&
            (locations[i] == locations[k])
        result
    }

    /**
     * Returns true if there is a winner on the current board, or if the board
     * is full and no other moves are available.
     *
     * @return true if the game is over
     */
    boolean isGameOver() {
        def winner = getWinner()
        def isFullBoard = (0 == getValidMoveCount())
        def result = (winner || isFullBoard)
        result
    }

    /**
     * Returns true if the given board location is available for a move.
     *
     * @param index an integer, an index to a board location
     * @return true if the given board location is available for a move.
     */
    boolean isValidMove(int index) {
        def result = (BLANK == locations[index])
        result
    }

    /**
     * Plays a move at the provided board location, if the move is valid.
     *
     * Returns true if the move is valid, otherwise returns false.
     *
     * @param index an integer, an index to a board location
     * @param player a Player
     * @return true if the move is valid
     */
    boolean playMove(int index, Player player) {
        def result = false
        if (isValidMove(index)) {
            locations[index] = player
            result = true
        }
        result
    }

    @Override
    String toString() {
        "       |       | \n" +
                "   ${locations[0]}   |   ${locations[1]}   |   ${locations[2]} \n" +
                "       |       |       \n" +
                "-----------------------\n" +
                "       |       | \n" +
                "   ${locations[3]}   |   ${locations[4]}   |   ${locations[5]} \n" +
                "       |       |       \n" +
                "-----------------------\n" +
                "       |       | \n" +
                "   ${locations[6]}   |   ${locations[7]}   |   ${locations[8]} \n" +
                "       |       |       \n"
    }

}
