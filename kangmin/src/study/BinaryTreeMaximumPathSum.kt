package study

// https://gist.github.com/fpdjsns/e72d37665a51768f00647d46f414ef0c
object BinaryTreeMaximumPathSum {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private var answer = 0
    private var maxi = 0
    fun maxPathSum(root: TreeNode?): Int {
        answer = root?.`val` ?: 0
        maxi = root?.`val` ?: 0

        recursive(root)

        return if (maxi >= 0) answer else maxi
    }

    private fun recursive(node: TreeNode?): Int {
        if (node == null) return 0
        val now = node.`val`
        maxi = Math.max(maxi, now)

        val left = recursive(node.left)
        val right = recursive(node.right)

        // 1. now
        // 2. now + left
        // 3. now + right
        // 4. now + left + right
        // 5. before
        var sum = Math.max(now, now + left)
        sum = Math.max(sum, now + right)
        answer = Math.max(answer, sum)
        answer = Math.max(answer, now + left + right)
        return Math.max(sum, 0)
    }
}