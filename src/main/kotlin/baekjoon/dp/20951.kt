package baekjoon.dp

class `20951` {
    private val MOD = 1e9.toInt() + 7

    fun solution() = with(System.`in`.bufferedReader()) {
        val (N, M) = readLine().split(" ").map(String::toInt)
        val G = buildMap<Int, MutableList<Int>> {
            repeat(M) {
                val (u, v) = readLine().split(" ").map(String::toInt)
                getOrPut(u) { mutableListOf() }.add(v)
                getOrPut(v) { mutableListOf() }.add(u)
            }
        }

        val dp = List(7 + 1) { IntArray(N + 1) }.apply {
            for (n in G.keys) {
                this[1][n] = G[n]!!.size
            }
        }
        for (l in 2..7) {
            for (n in G.keys) {
                for (prev in G[n]!!) {
                    dp[l][n] += dp[l - 1][prev]
                    dp[l][n] %= MOD
                }
            }
        }

        print(dp.last().fold(0) { acc, v -> (acc + v) % MOD })
    }
}