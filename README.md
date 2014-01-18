Groovy Tic-Tac-Toe
==================

The game Tic-Tac-Toe (Noughts & Crosses) written in Groovy.

[![Build Status](https://travis-ci.org/jbarker/groovy-tictactoe.png?branch=master)](https://travis-ci.org/jbarker/groovy-tictactoe)


Highlights
----------

* User-friendly command-line interface (CLI)
* Optional computer opponent


Building
--------

In your favorite shell, set your working directory to the project root and
build TicTacToe with `gradle`:

    $ gradle clean build uberjar


Running
-------

From the project root, run TicTacToe with `java`:

    $ java -jar build/libs/groovy-tictactoe.jar


Playing
-------

When TicTacToe is running, follow the instructions to play a game. TicTacToe
will prompt you for input to configure the game and to play a move on the game
board.

To play a move, enter a number that corresponds to the board spaces:

           |       |
       0   |   1   |   2
           |       |
    -----------------------
           |       |
       3   |   4   |   5
           |       |
    -----------------------
           |       |
       6   |   7   |   8
           |       |


Future
------

Possible changes and additions could include:

* Support for additional languages
* More fun and surprises in CLI text
* Better algorithm for computer opponent


Development
-----------

Developed with:

* [Groovy](http://groovy.codehaus.org/) 2.2.1
* [Gradle](http://www.gradle.org/) 1.10
* [JUnit](http://junit.org/) 4.11


Release History
---------------

0.9.8 - 13 January 2014

* Upgraded dependencies.

0.9.1 &ndash; 0.9.7

* Upgraded dependencies.

0.9.0 - 14 May 2012

* Initial version.
