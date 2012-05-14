package com.jbarker.code.groovy.tictactoe;

/**
 * Player for Tic-Tac-Toe.
 */
class Player {

    /**
     * Is this player the computer?
     */
    boolean computer

    /**
     * Either "X" or "O".
     */
    char marker

    /**
     * A user-friendly label for the player.
     */
    String name

    @Override
    String toString() {
        marker
    }

}
