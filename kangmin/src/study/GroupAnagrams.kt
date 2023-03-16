package study

object GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        val result = mutableListOf<List<String>>()

        val visited = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val sortedString = String(str.toCharArray().sorted().toCharArray())
            if (visited.contains(sortedString)) {
                visited[sortedString]!!.add(str)
            } else {
                visited[sortedString] = mutableListOf(str)
            }
        }

        for (key in visited.keys) {
            result.add(visited[key]!!)
        }

        return result
    }
}

fun main() {
    val result = GroupAnagrams.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    result.forEach {
        it.forEach { text ->
            print("$text ")
        }
        println()
    }
}