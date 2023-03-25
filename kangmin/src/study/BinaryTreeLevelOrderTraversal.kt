package study

object BinaryTreeLevelOrderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    val result = mutableListOf<MutableList<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {

        if (root == null) {
            return listOf()
        }

        recursive(root, 0)

        return result
    }

    private fun recursive(node: TreeNode, level: Int) {
        if (result.size == level) {
            result.add(mutableListOf(node.`val`))
        } else {
            result[level].add(node.`val`)
        }
        if (node.left != null) {
            recursive(node.left!!, level + 1)
        }
        if (node.right != null) {
            recursive(node.right!!, level + 1)
        }
    }
}

fun main() {
    val root = BinaryTreeLevelOrderTraversal.TreeNode(3)
    root.left = BinaryTreeLevelOrderTraversal.TreeNode(9)
    root.right = BinaryTreeLevelOrderTraversal.TreeNode(20)

    root.left!!.left = null
    root.left!!.right = null

    root.right!!.left = BinaryTreeLevelOrderTraversal.TreeNode(15)
    root.right!!.right = BinaryTreeLevelOrderTraversal.TreeNode(7)

    val result = BinaryTreeLevelOrderTraversal.levelOrder(root)

    result.forEach { list ->
        list.forEach { print("$it ") }
        println()
    }
}