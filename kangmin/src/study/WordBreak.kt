package study



object WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {

        val map = HashMap<String,Boolean>()
        wordDict.forEach { map[it] = true }
        val n = s.length

        val dp = BooleanArray(n + 1)
        dp[0] = true

        // 현재 위치부터 한칸씩 뒤로 탐색
        for (i in 1..n) {
            // 현재 위치에서부터 앞으로 탐색
            for (j in i - 1 downTo 0) {
                if (dp[j] && map.contains(s.substring(j, i))) {
                    dp[i] = true
                    break
                }
            }
        }

        return dp[n]
    }
}

fun main() {
//    println(WordBreak.wordBreak("catsandog", listOf("cats","dog","sand","and","cat")))
//    println(WordBreak.wordBreak("cars", listOf("car", "ca", "rs")))
    println(WordBreak.wordBreak("aaaaaaa", listOf("aaaa", "aaa")))

}