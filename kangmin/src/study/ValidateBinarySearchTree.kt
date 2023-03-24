package study

object ValidateBinarySearchTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return recursive(root, null, null)
    }

    private fun recursive(node: TreeNode?, leftParent: Int?, rightParent: Int?): Boolean {
        var result = true
        if (node?.`val` != null) {
            if (node.left != null) {

                if (leftParent != null && node.left!!.`val` <= leftParent) {
                    return false
                }

                if (node.left!!.`val` < node.`val`) {
                    result = recursive(node.left, null, Math.min(node.`val`, leftParent ?: Int.MAX_VALUE))
                } else {
                    return false
                }
            }
            if (node.right != null) {

                if (rightParent != null && rightParent <= node.right!!.`val`) {
                    return false
                }

                if (node.`val` < node.right!!.`val`) {
                    result = result && recursive(node.right, Math.min(node.`val`, rightParent ?: Int.MAX_VALUE), null)
                } else {
                    return false
                }
            }
            if (node.left == null && node.right == null) {
                if ((rightParent != null && node.`val` <= rightParent) || (leftParent != null && leftParent <= node.`val`)) {
                    return false
                }
            }
        }
        return result
    }
}

fun main() {
//    val tree = ValidateBinarySearchTree.TreeNode(22)
//
//    tree.left = ValidateBinarySearchTree.TreeNode(-4)
//    tree.right = null
//    tree.left!!.left = ValidateBinarySearchTree.TreeNode(-60)
//    tree.left!!.right = null
//    tree.left!!.left!!.left = ValidateBinarySearchTree.TreeNode(-90)
//    val tree = ValidateBinarySearchTree.TreeNode(120)
//
//    tree.left = ValidateBinarySearchTree.TreeNode(70)
//    tree.left!!.left = ValidateBinarySearchTree.TreeNode(50)
//    tree.left!!.right = ValidateBinarySearchTree.TreeNode(100)
//
//    tree.left!!.left!!.left = ValidateBinarySearchTree.TreeNode(20)
//    tree.left!!.left!!.right = ValidateBinarySearchTree.TreeNode(55)
//
//    tree.left!!.right!!.left = ValidateBinarySearchTree.TreeNode(75)
//    tree.left!!.right!!.right = ValidateBinarySearchTree.TreeNode(110)
//
//    tree.right = ValidateBinarySearchTree.TreeNode(140)
//    tree.right!!.left = ValidateBinarySearchTree.TreeNode(130)
//    tree.right!!.right = ValidateBinarySearchTree.TreeNode(160)
//
//    tree.right!!.left!!.left = ValidateBinarySearchTree.TreeNode(119)
//    tree.right!!.left!!.right = ValidateBinarySearchTree.TreeNode(135)
//
//    tree.right!!.right!!.left = ValidateBinarySearchTree.TreeNode(150)
//    tree.right!!.right!!.right = ValidateBinarySearchTree.TreeNode(200)
//
    val tree = ValidateBinarySearchTree.TreeNode(3)

    tree.left = ValidateBinarySearchTree.TreeNode(1)
    tree.left!!.left = ValidateBinarySearchTree.TreeNode(0)
    tree.left!!.right = ValidateBinarySearchTree.TreeNode(2)

//    tree.left!!.left!!.left = null
//    tree.left!!.left!!.right = null
//
//    tree.left!!.right!!.left = null
//    tree.left!!.right!!.right = ValidateBinarySearchTree.TreeNode(3)

    tree.right = ValidateBinarySearchTree.TreeNode(5)
    tree.right!!.left = ValidateBinarySearchTree.TreeNode(4)
    tree.right!!.right = ValidateBinarySearchTree.TreeNode(6)

    println(ValidateBinarySearchTree.isValidBST(tree))
}