package study

import java.util.*

object NumberOfIslands {
    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size

        var answer = 0

        val visited = Array(n) { BooleanArray(m) }

        for (y in 0 until n) {
            for (x in 0 until m) {
                if (grid[y][x] == '1' && !visited[y][x]) {
                    bfs(y, x, visited, n, m, grid)
                    answer++
                }
            }
        }
        return answer
    }

    private fun bfs(
        y: Int,
        x: Int,
        visited: Array<BooleanArray>,
        n: Int,
        m: Int,
        grid: Array<CharArray>
    ) {
        val queue = LinkedList<IntArray>()
        queue.addFirst(intArrayOf(y, x))
        val move = arrayOf(
            intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1)
        )

        while (queue.isNotEmpty()) {
            val temp = queue.removeFirst()
            val ty = temp[0]
            val tx = temp[1]
            visited[ty][tx] = true

            for (i in 0 until 4) {
                val my = ty + move[i][0]
                val mx = tx + move[i][1]

                if (my in 0 until n && mx in 0 until m && grid[my][mx] == '1' && !visited[my][mx]) {
                    queue.addFirst(intArrayOf(my, mx))
                }
            }
        }
    }

}

fun main() {
    println(NumberOfIslands.numIslands(arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )))
}