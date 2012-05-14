package com.jbarker.code.groovy.tictactoe;

import org.junit.Assert
import org.junit.Test

/**
 * Unit test for {@link Greedy}.
 *
 * @see Greedy
 */
class GreedyTest {

    @Test
    void testGetMove_baseCase() {
        def board = new Board()
        def player = new Player()
        def opponent = new Player()

        def greedy = new Greedy(board, player, opponent)
        def actual = greedy.getMove()

		// expected: center location
        def expected = 4
        Assert.assertEquals(expected, actual)
    }

	// TODO more tests

}
