package study

class TrieNode {
    var isWord = false
    var children = HashMap<Char, TrieNode>()
}
class Trie {

    private val root = TrieNode()
    fun insert(word: String) {
        var node = root
        for (ch in word) {
            if (!node.children.contains(ch)) {
                // 다음 문자로 이동할 자리가 없으면 추가
                node.children[ch] = TrieNode()
            }
            node = node.children[ch]!!  // 다음 문자로 이동
        }
        node.isWord = true  // 마지막까지 가야 word
    }

    fun search(word: String): Boolean {
        val result = find(word) // word 문자 수 만큼 node 이동시켜본다.
        if (result != null) {
            return result.isWord    // word 끝까지 왔다면 존재하는거다.
        }
        return false
    }

    fun startsWith(prefix: String): Boolean {
        return find(prefix) != null // 단어 여부와 상관없이 등록된 prefix인지만 앞에서부터 찾아가면 된다.
    }

    private fun find(input: String): TrieNode? {
        var node = root
        for (ch in input) {
            if (!node.children.contains(ch)) {
                return null
            }
            node = node.children[ch]!!
        }
        return node
    }
}