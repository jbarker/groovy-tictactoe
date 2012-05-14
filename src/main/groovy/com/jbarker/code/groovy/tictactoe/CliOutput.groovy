package com.jbarker.code.groovy.tictactoe;

/**
 * Command-line interface (CLI) output for Tic-Tac-Toe.
 */
class CliOutput {

	def showBoardState(Board board) {
		println board
	}

	def showGameOverDraw(Player player1, Player player2) {
		println "${player1.name} and ${player2.name} have battled to a draw."
		println ""
	}

	def showGameOverExit() {
		println "Until next time..."
		println ""
	}

	def showGameOverNow() {
		println "This game of Tic-Tac-Toe is over!"
		println ""
	}

	def showGameOverWinner(Player player) {
		println "No time for losers. ${player.name} is the champion!"
		println ""
	}

	def showGameStart() {
		println ""
		println "This is Tic-Tac-Toe. Let's get started!"
		println ""
	}

	def showGameStartHint() {
		println "Hint: Valid moves are: 0 - 8"
		println ""
	}

	def showMoveInvalidInput() {
        println "Nice try. Please choose a valid move."
		println ""
	}

	def showMoveInvalidLocation(Integer location) {
		println "${location} is already taken. Try again."
		println ""
	}

	def showMovePrompt(Player player) {
		print "Your move, ${player.name} (${player.marker}) > "
	}

	def showMoveValid(Integer number, Player player) {
		println "${player.name} ($player.marker) > ${number}"
		println ""
	}

}
