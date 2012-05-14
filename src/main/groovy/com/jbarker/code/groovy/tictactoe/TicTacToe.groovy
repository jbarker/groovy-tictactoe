package com.jbarker.code.groovy.tictactoe;

/**
 * Groovy Tic-Tac-Toe.
 */
class TicTacToe {

	static void main(args) {
		TicTacToe ticTacToe = new TicTacToe()
		ticTacToe.initGame()
	}

	private Board board
	private CliInput input
	private CliOutput output
	private Player player1
	private Player player2

	/**
	 * Perform a move for the current computer player.
	 *
	 * @param player a Player, the computer player
	 * @param opponent a Player, the human opponent
	 */
	private def doComputerMove(Player player, Player opponent) {
		def number = new Greedy(board, player, opponent).getMove()
		board.playMove(number, player)
		output.showMoveValid(number, player)
	}

	/**
	 * Performs the main game loop, alternate turns between players until
	 * the game is over.
	 */
	private def doGameLoop() {
		output.showGameStartHint()

		while (!board.isGameOver()) {
			doMove(player1, player2)

			if (!board.isGameOver()) {
				doMove(player2, player1)
			}
		}

		doGameOver()
		if (input.gamePlayAgain()) {
			initGame()
		} else {
			output.showGameOverExit()
		}
	}

	/**
	 * Performs the game over action.
	 */
	private def doGameOver() {
		output.showBoardState(board)
		output.showGameOverNow()

		// winner?
		def winner = board.getWinner()
		if (winner) {
			output.showGameOverWinner(winner)
		} else {
			output.showGameOverDraw(player1, player2)
		}
	}

	/**
	 * Perform a move for the current human player.
	 *
	 * @param player a Player, the current human player
	 */
	private def doHumanMove(Player player) {
		output.showBoardState(board)
		output.showMovePrompt(player)

		def input = input.gameMove()
		switch (input) {
			case '0'..'8':
				def number = input.toInteger()
				if (!board.playMove(number, player)) {
					// not successful? request another move
					output.showMoveInvalidLocation(number)
					doHumanMove(player)
				}
				break
			default:
				output.showMoveInvalidInput()
				doHumanMove(player)
				break
		}
	}

	/**
	 * Perform a move for the given current player against the given opponent player.
	 *
	 * @param player a Player, the current player
	 * @param opponent a Player, the opponent player
	 */
	private def doMove(Player player, Player opponent) {
		if (player.computer) {
			doComputerMove(player, opponent)
		} else {
			doHumanMove(player)
		}
	}

	/**
	 * Initialize the overall game.
	 */
	def initGame() {
		output = new CliOutput()
		output.showGameStart()

		board = new Board()

		input = new CliInput()
		(player1, player2) = input.configPlayers()

		doGameLoop()
	}

}
