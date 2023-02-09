package baekjoon.graph

// 한 노드에서 특정 노드로 가는 경우의 수 <- 유일하다.
// 특정 노드에서 가장 먼 노드를 구하고, 그 노드에게서 가장 먼 노드를 구한다.

class `1967` {

    data class Edge(
        val next:Int,
        val cost:Int
    )

    private var n = 0
    private lateinit var nextNode: Array<MutableList<Edge>>
    private lateinit var distance: IntArray

    private fun search(prev:Int, now: Int, totalCost:Int){
        for (edge in nextNode[now]){
            if (edge.next != prev){
                distance[edge.next] += (totalCost + edge.cost)
                search(now, edge.next, distance[edge.next])
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        n = readLine().toInt()
        nextNode = Array(n) { mutableListOf() }
        repeat(n - 1) {
            val (p, c, cost) = readLine().split(" ").map { it.toInt() - 1 }
            nextNode[p].add(Edge(c, cost + 1))
            nextNode[c].add(Edge(p, cost + 1))
        }

        distance = IntArray(n)
        search(-1, 0, 0)

        val farOne = distance.withIndex().maxBy { it.value }.index
        distance = IntArray(n)
        search(-1, farOne, 0)

        println(distance.maxOf { it })
    }

}

fun main() {

    `1967`().solution()

}