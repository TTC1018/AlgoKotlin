package baekjoon.shortestpath

class `11265` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val P = List(N) { readLine().split(" ").map(String::toLong) }
        val F = List(N) { P[it].toLongArray() }
        for (k in F.indices) {
            for (i in F.indices) {
                for (j in F.indices) {
                    F[i][j] = minOf(F[i][j], F[i][k] + F[k][j])
                }
            }
        }
        val sb = StringBuilder()
        repeat(M) {
            var (A, B, C) = readLine().split(" ").map { it.toInt() - 1 }
            C++
            if (F[A][B] <= C) {
                sb.appendLine("Enjoy other party")
            } else {
                sb.appendLine("Stay here")
            }
        }
        print(sb.dropLast(1))
    }
}