package study

object SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        val m = matrix[0].size

        val yRecord = BooleanArray(n)
        val xRecord = BooleanArray(m)

        for (y in 0 until n) {
            for (x in 0 until m) {
                if (matrix[y][x] == 0) {
                    yRecord[y] = true
                    xRecord[x] = true
                }
            }
        }
        for (x in 0 until m) {
            if (xRecord[x]) {
                for (y in 0 until n) {
                    matrix[y][x] = 0
                }
            }
        }

        for (y in 0 until n) {
            if (yRecord[y]) {
                matrix[y] = IntArray(m) { 0 }
            }
        }
    }
}

fun main() {
    val arr = arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5))
    SetMatrixZeroes.setZeroes(arr)

    arr.forEach { a ->
        a.forEach { print("$it ") }
        println()
    }
}