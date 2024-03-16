package baekjoon.graph

class `21735` {
    private data class Loc(
        val x: Int,
        val t: Int,
        val s: Int,
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val a = listOf(-1) + readLine().split(" ").map(String::toInt)
        val V = List(N + 2) { IntArray(M + 1) { -1 } }
        val q = ArrayDeque<Loc>().apply { add(Loc(0, 0, 1)) }
        var answer = 0
        while (q.isNotEmpty()) {
            val (x, t, s) = q.removeFirst()
            if (x >= N || t == M) {
                answer = maxOf(answer, s)
                continue
            }

            val nextStep = s + a.getOrElse(x + 1) { 0 }
            if (t + 1 <= M && V[x + 1][t + 1] < nextStep) {
                V[x + 1][t + 1] = nextStep
                q.add(Loc(x + 1, t + 1, nextStep))
            }
            val nextStep2 = s / 2 + a.getOrElse(x + 2) { 0 }
            if (t + 1 <= M && V[x + 2][t + 1] < nextStep2) {
                V[x + 2][t + 1] = nextStep2
                q.add(Loc(x + 2, t + 1, nextStep2))
            }
        }
        print(answer)
    }
}