package study

object SameTree {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return dfs(p, q)
    }

    private fun dfs(a: TreeNode?, b: TreeNode?): Boolean {

        if (a == null && b == null) {
            return true
        } else if (a == null || b == null) {
            return false
        } else {
            return a.`val` == b.`val` && dfs(a.left, b.left) && dfs(a.right, b.right)
        }
    }
}