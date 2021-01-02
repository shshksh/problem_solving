package codinginterview.nonlinear.graph

import java.util.*
import javax.swing.plaf.TreeUI

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val visited = Stack<Int>()

    fun dfs(to: Int): Boolean {
        if (to in visited)
            return false

        visited.push(to)
        for (v in (graph[visited.peek()] ?: mutableListOf())) {
            if (!dfs(v)) return false
        }
        visited.pop()
        return true
    }

    for (prerequisite in prerequisites) {
        graph.getOrPut(prerequisite[0]) {
            mutableListOf()
        }.add(prerequisite[1])

        if (!dfs(prerequisite[1]))
            return false
    }

    return true
}

