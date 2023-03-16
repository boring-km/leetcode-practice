package study

object RotateImage {

    fun rotate(matrix: Array<IntArray>): Unit {

        val n = matrix.size

        val result = Array(n) { IntArray(n) }

        for (i in 0 until n) {
            for (j in 0 until n) {
                result[j][n - i - 1] = matrix[i][j]
            }
        }

        result.copyInto(matrix)
    }
}

fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    RotateImage.rotate(matrix)
    matrix.forEach {
        it.forEach { num -> print("$num ") }
        println()
    }
}