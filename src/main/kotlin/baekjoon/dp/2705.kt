package baekjoon.dp

class `2705` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val dp = IntArray(1000 + 1) { 1 }.apply { this[0] = 0 }
        for (n in 1..1000) {
            for (c in 0 until n) {
                (n - c).takeIf { it % 2 == 0 }
                    ?.let { dp[n] += dp[it / 2] }
            }
        }

        print(
            List(readLine().toInt()) { dp[readLine().toInt()] }
                .joinToString("\n")
        )
    }
}