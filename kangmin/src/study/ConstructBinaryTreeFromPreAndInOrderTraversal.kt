package study

// https://luckydavekim.github.io/algorithm/leetcode/construct-binary-tree-from-preorder-and-inorder-traversal
// Python 예제에서는 Array를 slice해서 구현하는데 Kotlin에서는 런타임에러가 자꾸 나온다.
object ConstructBinaryTreeFromPreAndInOrderTraversal {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        return recursive(preorder, inorder, 0, 0, inorder.size - 1)
    }

    private fun recursive(
        preorder: IntArray,
        inorder: IntArray,
        preIndex: Int,
        inStartIndex: Int,
        inEndIndex: Int
    ): TreeNode? {
        if (preIndex >= preorder.size || inStartIndex > inEndIndex) {
            return null
        }
        val node = TreeNode(preorder[preIndex])
        var inorderIndex = 0
        for (i in inStartIndex..inEndIndex) {
            if (inorder[i] == node.`val`) {
                inorderIndex = i
                break
            }
        }

        inorder.indexOf(node.`val`)

        node.left = recursive(
            preorder,
            inorder,
            preIndex + 1,
            inStartIndex,
            inorderIndex - 1
        )
        node.right = recursive(
            preorder,
            inorder,
            preIndex + inorderIndex - inStartIndex + 1,
            inorderIndex + 1, inEndIndex
        )
        return node
    }
}

fun main() {

    val preorder = intArrayOf(3, 9, 20, 15, 7)
    val inorder = intArrayOf(9, 3, 15, 20, 7)

//    val result = inorder.slice(IntRange(3, inorder.size-1))
//    result.forEach { print("$it ") }

    ConstructBinaryTreeFromPreAndInOrderTraversal.buildTree(preorder, inorder)
}