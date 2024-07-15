package baekjoon.prefixsum

class `17390` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, Q) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toInt)
            .sorted()
        val P = IntArray(N).apply {
            this[0] = A.first()
            for (i in 1 until N) {
                this[i] += this[i - 1] + A[i]
            }
        }
        val sb = StringBuilder()
        repeat(Q) {
            val (L, R) = readLine().split(" ").map { it.toInt() - 1 }
            sb.appendLine(P[R] - P.getOrElse(L - 1) { 0 })
        }
        print(sb.dropLast(1))
    }
}