package study

object ValidateBinarySearchTree {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun isValidBST(root: TreeNode?): Boolean {
        return recursive(root, null, null)
    }


    private fun recursive(node: TreeNode?, min: Int?, max: Int?): Boolean {
        if (node == null) return true
        if (min != null && node.`val` <= min) return false
        if (max != null && node.`val` >= max) return false
        return recursive(node.right, node.`val`, max) && recursive(node.left, min, node.`val`)
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