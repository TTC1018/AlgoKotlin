package baekjoon.bruteforce

class `18231` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val G = List<MutableList<Int>>(N) { mutableListOf() }.apply {
            repeat(M) {
                val (u, v) = readLine().split(" ").map { it.toInt() - 1 }
                this[u].add(v)
                this[v].add(u)
            }
        }
        val K = readLine().toInt()
        val P = readLine().split(" ").map { it.toInt() - 1 }.toSet()

        val answer = mutableListOf<Int>()
        val visited = mutableSetOf<Int>()
        for (p in P) {
            val temp = mutableListOf(p) // p에 떨어졌을 때
            for (next in G[p]) {
                if (next !in P) { // 터진 후보에 없으면 불가능
                    temp.clear()
                    break
                }
                temp.add(next)
            }

            temp.takeIf { it.isNotEmpty() }
                ?.let {
                    answer.add(p + 1)
                    visited.addAll(it)
                }

            if (visited.size == K) {
                print("${answer.size}\n${answer.sorted().joinToString(" ")}")
                return
            }
        }
        print(-1)
    }
}