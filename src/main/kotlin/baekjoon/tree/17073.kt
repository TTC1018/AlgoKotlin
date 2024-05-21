package baekjoon.tree

class `17073` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val G = List(N) { mutableListOf<Int>() }.apply {
            repeat(N - 1) {
                val (U, V) = readLine().split(" ").map { it.toInt() - 1 }
                this[U].add(V)
                this[V].add(U)
            }
        }
        val answer = M.toDouble() / G.drop(1).filter { it.size == 1 }.size
        print("%.4f".format(answer))
    }
}