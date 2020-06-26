package games.gameOfFifteen

import board.Direction
import games.game.Game

/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
        GameOfFifteen(initializer.initialPermutation.toMutableList())

class GameOfFifteen(private var list: MutableList<Int?>) : Game {
    private var x = 4
    private var y = 4

    override fun initialize() {
        list.add(null)
    }

    override fun canMove(): Boolean {
        return true
    }

    override fun hasWon(): Boolean {
        return list.dropLast(1) == (1..15).toList()
    }

    override fun processMove(direction: Direction) {
        when (direction) {
            Direction.UP -> {
                if (x != 4) {
                    list[(x-1)*4+(y-1)] = list[(x)*4+(y-1)]
                    list[(x)*4+(y-1)] = null
                    x++
                }
            }
            Direction.DOWN -> {
                if (x != 1) {
                    list[(x-1)*4+(y-1)] = list[(x-2)*4+(y-1)]
                    list[(x-2)*4+(y-1)] = null
                    x--
                }
            }
            Direction.LEFT -> {
                if (y != 4) {
                    list[(x-1)*4+(y-1)] = list[(x-1)*4+(y)]
                    list[(x-1)*4+(y)] = null
                    y++
                }
            }
            Direction.RIGHT -> {
                if (y != 1) {
                    list[(x-1)*4+(y-1)] = list[(x-1)*4+(y-2)]
                    list[(x-1)*4+(y-2)] = null
                    y--
                }
            }
        }
    }

    override fun get(i: Int, j: Int): Int? {
        return list[(i - 1) * 4 + (j - 1)]
    }

}

