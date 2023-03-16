package study

class CombinationSum {

    var result: MutableList<List<Int>> = ArrayList()

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int?>> {
        for (i in candidates.indices) {
            val temp = ArrayList<Int>()
            temp.add(candidates[i])
            backtracking(candidates, i, 1, target - candidates[i], temp)
        }
        return result
    }

    private fun backtracking(candidates: IntArray, index: Int, tempSize: Int, target: Int, temp: MutableList<Int>) {
        if (target == 0) {  // target에서 후보자를 다 빼고 0이 된다면 결과에 추가
            result.add(ArrayList(temp))
            return
        }
        val len = candidates.size
        for (i in index until len) {
            if (candidates[i] <= target) {
                temp.add(candidates[i])
                backtracking(candidates, i, tempSize + 1, target - candidates[i], temp)
                temp.removeAt(tempSize)
            }
        }
    }
}

fun main() {
    val result = CombinationSum().combinationSum(intArrayOf(2,3,6,7), 7)
    for (item in result) {
        item.forEach { print("$it ") }
        println()
    }
}