package study

// https://luckydavekim.github.io/algorithm/leetcode/construct-binary-tree-from-preorder-and-inorder-traversal
// Python 예제에서는 Array를 slice해서 구현하는데 Kotlin에서는 런타임에러가 자꾸 나온다.
// 성공: https://velog.io/@wlgns2223/leetcode-105-Construct-Binary-Tree-From-Preorder-and-Inorder-Traversal
object ConstructBinaryTreeFromPreAndInOrderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return recursive(preorder.toMutableList(), inorder.toMutableList())
    }

    private fun recursive(preorderList: MutableList<Int>, inorder: List<Int>): TreeNode? {
        if (inorder.isNotEmpty()) {
            val index = inorder.indexOf(preorderList.removeAt(0))
            val root = TreeNode(inorder[index])
            root.left = recursive(preorderList, inorder.slice(IntRange(0, index-1)))
            root.right = recursive(preorderList, inorder.slice(IntRange(index+1, inorder.size-1)))
            return root
        } else {
            return null
        }
    }
}

fun main() {

    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)

//    val result = inorder.slice(IntRange(2, 4))
//    result.forEach { print("$it ") }

    ConstructBinaryTreeFromPreAndInOrderTraversal.buildTree(preorder, inorder)
}