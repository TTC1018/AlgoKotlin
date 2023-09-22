package baekjoon.baekjoon.disjointset

private const val MOD = 1000000007

class `24542` {
    private var N = 0
    private var M = 0
    private lateinit var F: List<MutableList<Int>>
    private lateinit var visited: BooleanArray
    private var answer = 1L
    private var tempAnswer = 1L

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run { N = first(); M = last() }
        F = List(N) { mutableListOf() }
        visited = BooleanArray(N) { false }
        repeat(M) {
            val (u, v) = readLine().split(" ").map { it.toInt() - 1 }
            F[u].add(v)
            F[v].add(u)
        }

        for (num in 0 until N) {
            if (visited[num].not()) {
                visited[num] = true
                tempAnswer = 1L

                val q = ArrayDeque<Int>().apply { add(num) }
                while (q.isNotEmpty()) {
                    val now = q.removeFirst()

                    for (next in F[now]) {
                        if (visited[next].not()) {
                            tempAnswer++
                            visited[next] = true
                            q.add(next)
                        }
                    }
                }

                answer = (answer * tempAnswer) % MOD
            }
        }

        print(answer)
    }
}

fun main() {
    `24542`().solution()
}