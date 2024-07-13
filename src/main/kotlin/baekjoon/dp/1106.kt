package baekjoon.dp

class `1106` {

    private data class City(
        val p: Int,
        val c: Int,
    )

    private val LIMIT = 99

    fun solution() = with(System.`in`.bufferedReader()) {
        val (C, N) = readLine().split(" ").map(String::toInt)
        val cities = List(N) { readLine().split(" ").map(String::toInt).run { City(first(), last()) } }
        val dp = IntArray(C + LIMIT + 1) { Int.MAX_VALUE }.apply {
            this[0] = 0
        }
        for ((p, c) in cities) {
            for (n in c until dp.size) {
                if (dp[n - c] != Int.MAX_VALUE)
                    dp[n] = dp[n].coerceAtMost(dp[n - c] + p)
            }
        }
        print(dp.slice(C until dp.size).minOf { it })
    }

}