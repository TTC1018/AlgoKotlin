package baekjoon.prefixsum

class `19951` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val H = readLine().split(" ").map(String::toInt).toIntArray()
        val P = IntArray(N).apply {
            repeat(M) {
                val (a, b, k) = readLine().split(" ").map(String::toInt)
                this[a-1] += k
                if (b < N)
                    this[b] -= k
            }
            for (i in 1 until N) {
                this[i] += this[i-1]
            }
        }
        print(H.mapIndexed { i, v -> v + P[i] }.joinToString(" "))
    }
}