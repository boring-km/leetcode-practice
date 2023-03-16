package study

// TODO 성능 개선 필요함
object SpiralMatrix {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        val mx = listOf(1, 0, -1, 0)
        val my = listOf(0, 1, 0, -1)

        val n = matrix.size
        val m = matrix[0].size

        val visited = Array(n) { BooleanArray(m) }

        var direction = 0
        var curY = 0
        var curX = 0

        val result = mutableListOf<Int>()

        while (result.size < m * n) {
            if (!visited[curY][curX]) {
                visited[curY][curX] = true

                result.add(matrix[curY][curX])

                val nextX = curX + mx[direction]
                val nextY = curY + my[direction]

                if (nextX in 0 until m && nextY in 0 until n) {
                    if (visited[nextY][nextX]) {
                        val triple = change(direction, curX, mx, curY, my, m, n)
                        curX = triple.first
                        curY = triple.second
                        direction = triple.third
                    } else {
                        curX = nextX
                        curY = nextY
                    }
                }
            } else {
                val triple = change(direction, curX, mx, curY, my, m, n)
                curX = triple.first
                curY = triple.second
                direction = triple.third
            }
        }

        return result
    }

    private fun change(
        direction: Int,
        curX: Int,
        mx: List<Int>,
        curY: Int,
        my: List<Int>,
        m: Int,
        n: Int
    ): Triple<Int, Int, Int> {
        // 이미 방문했던 길이라면 방향 틀기

        // 방향 틀고
        var direction1 = direction
        var curX1 = curX
        var curY1 = curY
        if (direction1 == 3) direction1 = 0
        else direction1++

        // 다시 한칸 이동
        val nextX = curX1 + mx[direction1]
        val nextY = curY1 + my[direction1]

        if (nextX in 0 until m && nextY in 0 until n) {
            curX1 = nextX
            curY1 = nextY
        }
        return Triple(curX1, curY1, direction1)
    }
}

fun main() {
    var result = SpiralMatrix.spiralOrder(arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)))
    result.forEach { print("$it ") }
    println()
    result = SpiralMatrix.spiralOrder(arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12)))
    result.forEach { print("$it ") }
}