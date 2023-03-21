package study

object UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val area = Array(n) { IntArray(m) }
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (i == 0 || j == 0) {
                    area[i][j] = 1
                } else {
                    // 왼쪽과 위에서 값을 더해오기
                    area[i][j] = area[i - 1][j] + area[i][j - 1]
                }
            }
        }
        return area[n-1][m-1]
    }
}

fun main() {
    val result = UniquePaths.uniquePaths(3,7)
    println(result)
}