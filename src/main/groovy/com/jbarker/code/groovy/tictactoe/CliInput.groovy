package com.jbarker.code.groovy.tictactoe;

/**
 * Command-line interface (CLI) configuration for Tic-Tac-Toe.
 */
class CliInput {

	/**
	 * Options that indicate an affirmative response. Input should be 'trim' and
	 * 'toLowerCase' before comparing against this list.
	 */
	static List<String> yesOptions = [
		"y",
		"yes",
		"yep",
		"yup",
		"sure",
		"ok",
		"whatever",
		"da"
	]

	/**
	 * Reader for CLI input.
	 */
	Reader reader

	/**
	 * Default constructor.
	 */
	CliInput() {
		reader = System.in.newReader()
	}

	/**
	 * Returns the list of players, fully configured and in playable order.
	 *
	 * @return the List of Player
	 */
	List<Player> configPlayers() {
		def input

		// players
		Player player1 = new Player()
		Player player2 = new Player()

		// name?
		println "Hi! What's your name?"
		print "> "

		input = reader.readLine().trim()

		switch (input) {
			case ["", null]:
				player1.name = "The Blank"
				println "Your new name is now: ${player1.name}"
				break
			default:
				player1.name = "${input}"
				println "Good luck, ${player1.name}!"
				break
		}
		println ""

		// computer opponent?
		println "Do you prefer a computer opponent today?"
		print "> "

		input = reader.readLine().trim().toLowerCase()
		switch (input) {
			case yesOptions:
				player2.computer = true
				println "Got it. Prepare to be destroyed."
				break
			default:
				println "Puny humans and their silly games..."
				break;
		}

		// opponent name?
		if (player2.computer) {
			player2.name = "Amiga 1000"
			println "Playing you today is: ${player2.name}"
		} else {
			println ""
			println "So, who is your opponent this game?"
			print "> "
			input = reader.readLine().trim()
			// assign
			switch (input) {
				case ["", null]:
					player2.name = "The Other"
					println "We shall call your opponent: ${player2.name}"
					break
				default:
					player2.name = "${input}"
					println "${player2.name}, watch out! ${player1.name} is quite good."
					break
			}
		}
		println ""

		// marker?
		println "${player1.name}, do you feel like an X or O this time?"
		print "> "

		input = reader.readLine()
		switch (input) {
			case ["0", "o", "O"]:
				player1.marker = "O"
				player2.marker = "X"
				break
			default:
				player1.marker = "X"
				player2.marker = "O"
				break
		}

		// marker message
		switch (input) {
			case "0":
				println "0? That's a number, you know. You will be O."
				break
			case "o":
				println "${input}? Think bigger. You are O."
				break
			case "O":
				println "O-k. ${input} for you."
				break
			case "x":
				println "${input}? Think bigger. You are X."
				break
			case "X":
				println "eXcellent choice. ${input} for you."
				break
			default:
				println "Really? ${input}? You are X. Deal with it."
				break
		}
		println ""

		println "${player2.name} has no choice and will be ${player2.marker} this game."
		println ""

		// first?
		println "Want to start, ${player1.name}?"
		print "> "
		input = reader.readLine().trim().toLowerCase()
		switch (input) {
			case yesOptions:
				println "Understood."
				println ""
				break
			default:
				println "Confident much?"
				println ""
			// the former player 1 will not start and is now player 2
				(player1, player2) = [player2, player1]
				break
		}

		[player1, player2]
	}

	/**
	 * Returns the user input for the next game move.
	 *
	 * @return a String, the next game move
	 */
	String gameMove() {
		def input = reader.readLine().trim()
		input
	}

	/**
	 * Returns true if the user would like to play another game.
	 *
	 * @return true if the user would like to play another game.
	 */
	boolean gamePlayAgain() {
		def result = false

		// again?
		print "Another game? > "

		def input = reader.readLine().trim().toLowerCase()
		switch (input) {
			case yesOptions:
				result = true
				break
			default:
				break
		}

		result
	}

}
