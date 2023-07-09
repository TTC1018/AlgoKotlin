package baekjoon.dp

class `1633` {
    private data class Player(
        val w: Int,
        val b: Int
    )

    fun solution() = with(System.`in`.bufferedReader()) {
        val P = mutableListOf<Player>().apply {
            while (true) {
                try {
                    val ip = readLine()
                    if (ip.isNullOrEmpty())
                        break

                    add(ip.trim().split(" ").map(String::toInt).let { Player(it[0], it[1]) })
                } catch (e: Exception) {
                    break
                }
            }
        }

        val dp = Array(P.size) { Array(15 + 1) { IntArray(15 + 1) } }
            .also { it[0][1][0] = P[0].w; it[0][0][1] = P[0].b }
        for (i in 1 until P.size) {
            for (w in 0..15) {
                for (b in 0..15) {
                    if (w > 0)
                        dp[i][w][b] = maxOf(dp[i][w][b], dp[i - 1][w - 1][b] + P[i].w)
                    if (b > 0)
                        dp[i][w][b] = maxOf(dp[i][w][b], dp[i - 1][w][b - 1] + P[i].b)
                    dp[i][w][b] = maxOf(dp[i][w][b], dp[i - 1][w][b])
                }
            }
        }

        print(dp[P.size - 1][15][15])
    }
}

fun main() {
    `1633`().solution()
}