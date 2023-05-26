package baekjoon

class `6497` {

    private lateinit var parent: IntArray

    data class Edge(
        val start: Int,
        val end: Int,
        val cost: Int
    ): Comparable<Edge> {
        override fun compareTo(other: Edge) = this.cost.compareTo(other.cost)
    }

    private fun findParent(node: Int): Int {
        if (node != parent[node])
            parent[node] = findParent(parent[node])

        return parent[node]
    }

    private fun unionParent(a: Int, b: Int) {
        val pa = findParent(a)
        val pb = findParent(b)

        if (pa < pb)
            parent[pb] = pa
        else
            parent[pa] = pb
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        while (true) {

            val (m, n) = readLine().split(" ").map { it.toInt() }
            if (m == 0 && n == 0)
                break

            parent = IntArray(m) { it }
            val edges = Array(n) { readLine().split(" ").map { it.toInt() }.let { Edge(it[0], it[1], it[2]) } }
            edges.sort()

            // 최소 신장 트리
            var answer = 0
            for (edge in edges) {
                if (findParent(edge.start) != findParent(edge.end)) {
                    unionParent(edge.start, edge.end)
                    answer += edge.cost
                }
            }

            println(edges.sumOf { it.cost } - answer)
        }

    }

}

fun main() {

    `6497`().solution()

}