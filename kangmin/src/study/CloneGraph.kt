package study

import java.util.Deque
import java.util.LinkedList

object CloneGraph {

    class Node(var `val`: Int) {
        var neighbors: ArrayList<Node?> = ArrayList<Node?>()
    }

    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null

        val nodes = HashMap<Int, Node>()
        nodes[node.`val`] = Node(node.`val`)

        // BFS
        val queue: Deque<Node> = LinkedList()
        queue.add(node)

        while (queue.isNotEmpty()) {
            val temp = queue.pollFirst()
            val cur = nodes[temp.`val`]
            val neighbors = temp.neighbors

            for (item in neighbors) {
                if (!nodes.contains(item!!.`val`)) {
                    nodes[item.`val`] = Node(item.`val`)
                    queue.add(item)
                }
                cur!!.neighbors.add(nodes[item.`val`])
            }
        }
        return nodes[node.`val`]
    }
}