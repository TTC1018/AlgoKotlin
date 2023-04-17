package baekjoon.dp
import kotlin.math.min

class `1229` {

    fun solution() = with(System.`in`.bufferedReader()){

        val N = readLine().toInt()
        // hn = n * (2 * n - 1)
        val h = mutableListOf<Int>().apply {
            (1..N).forEach {
                add(it * (2 * it - 1))
            }
        }
        val base = intArrayOf(0, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6, 2)

        when {
            N < 13 -> print(base[N])
            N >= 13 -> {
                val dp = IntArray(N + 1) { 1e9.toInt() }.apply {
                    this[0] = 0
                    (1..12).forEach { this[it] = base[it] }
                }

                (13..N).forEach { n ->
                    var idx = 0
                    while (h[idx] <= n) {
                        dp[n] = min(dp[n], dp[n - h[idx]] + 1)
                        idx += 1
                    }
                }
                print(dp[N])
            }
        }


    }

}

fun main() {

    `1229`().solution()

}