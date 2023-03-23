package study

// BFS로 했다가 실패함
object WordSearch {
    private var visited: Array<BooleanArray>? = null

    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (word.isEmpty()) return true
        val row = board.size
        val col = board[0].size
        visited = Array(row) { BooleanArray(col) }
        for (y in 0 until row) {
            for (x in 0 until col) {
                if (recursive(board, word, 0, y, x)) {
                    return true
                }
            }
        }
        return false
    }

    private val moves = arrayOf(arrayOf(-1, 0), arrayOf(1, 0), arrayOf(0, -1), arrayOf(0, 1))

    private fun recursive(board: Array<CharArray>, word: String, cur: Int, y: Int, x: Int): Boolean { //n : word의 인덱스
        if (cur == word.length) return true
        if (y < 0 || x < 0 || y >= board.size || x >= board[0].size) return false
        if (visited!![y][x]) return false
        if (word[cur] != board[y][x]) return false

        // 일치하는 칸을 찾은 경우
        visited!![y][x] = true

        var result = false

        for (move in moves) {
            result = result || recursive(board, word, cur + 1, y + move[0], x + move[1])
        }

        // 만약 연속된 연산에서 word를 찾지 못하면  해당 칸을 다시 계산해야하므로 false로 갱신해준다.
        if (!result) {
            visited!![y][x] = false
        }
        return result
    }
}

fun main() {
    var result = WordSearch.exist(
        arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'E', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        ), "ABCESEEEFS"
    )
    println(result)
    result = WordSearch.exist(
        arrayOf(
            charArrayOf('A', 'B')
        ), "A"
    )
    println(result)
}