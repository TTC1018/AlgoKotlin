package baekjoon.prefixsum

class `14465` {
    fun main() = with(System.`in`.bufferedReader()) {
        val (N, K, B) = readLine().split(" ").map(String::toInt)
        val L = IntArray(N) { 1 }.apply {
            repeat(B) {
                this[readLine().toInt() - 1] = 0
            }
        }
        val P = IntArray(N).apply { this[0] = L[0] }
        for (i in 1 until N) {
            P[i] += P[i-1]+L[i]
        }

        var maxVal = 0
        for (i in K until N) {
            maxVal = maxOf(maxVal, P[i] - P[i-K])
        }
        print(K - maxVal)
    }
}