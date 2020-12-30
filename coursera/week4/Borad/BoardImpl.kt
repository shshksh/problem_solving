package board

import board.Direction.*

open class SquareBoardImpl(override val width: Int) : SquareBoard {
    private val cells = Array(width) { row: Int ->
        Array(width) { column: Int ->
            Cell(row + 1, column + 1)
        }
    }

    override fun getCellOrNull(i: Int, j: Int): Cell? =
            if (i in 1..width && j in 1..width)
                cells[i - 1][j - 1]
            else
                null

    override fun getCell(i: Int, j: Int): Cell =
            if (i in 1..width && j in 1..width)
                cells[i - 1][j - 1]
            else
                throw IllegalArgumentException()

    override fun getAllCells(): Collection<Cell> = cells.flatten()

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        if (jRange.first > jRange.last)
            return cells[i - 1].reversed().filter { (_, j) -> j in jRange }
        return cells[i - 1]
                .filter { (_, j) -> j in jRange }
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        if (iRange.first > iRange.last)
            return cells
                    .map { arrayOfCells -> arrayOfCells[j - 1] }
                    .reversed()
                    .filter { (i, _) -> i in iRange }
        return cells
                .map { arrayOfCells -> arrayOfCells[j - 1] }
                .filter { (i, _) -> i in iRange }
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? = when (direction) {
        UP -> getCellOrNull(i - 1, j)
        DOWN -> getCellOrNull(i + 1, j)
        RIGHT -> getCellOrNull(i, j + 1)
        LEFT -> getCellOrNull(i, j - 1)
    }
}

class GameBoardImpl<T>(width: Int) : SquareBoardImpl(width), GameBoard<T> {

    private val table = mutableMapOf<Cell, T?>()

    init {
        getAllCells().forEach { cell: Cell -> table[cell] = null }
    }

    override fun get(cell: Cell): T? = table[cell]

    override fun set(cell: Cell, value: T?) {
        table[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        val list = table.values.filter(predicate)
        return getAllCells().filter { cell ->
            table[cell] in list
        }
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        val target = table.values.find(predicate)
        return getAllCells().find { cell -> table[cell] == target }
    }

    override fun any(predicate: (T?) -> Boolean): Boolean = table.values.any(predicate)

    override fun all(predicate: (T?) -> Boolean): Boolean = table.values.all(predicate)

}

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)

fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl<T>(width)