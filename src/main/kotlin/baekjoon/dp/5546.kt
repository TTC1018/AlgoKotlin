package baekjoon.dp

private const val NONE = 0
private const val ATE = 1

class `5546` {
    fun main() = with(System.`in`.bufferedReader()) {
        val (N, K) = readLine().split(" ").map(String::toInt)
        val P = buildMap<Int, Int> {
            repeat(K) {
                val (A, B) = readLine().split(" ").map { it.toInt() - 1 }
                put(A, B)
            }
        }
        val dp = List(N) { List(2) { IntArray(3) } }.apply {
            P[0]?.let {
                this[0][NONE][it] = 1
            } ?: run {
                this[0][NONE].fill(1)
            }
        }

        for (n in 1 until N) {
            if (n in P) {
                val s = P[n]!!
                // 이전에 안 먹었다면 나머지 소스의 경우 더하기, 같은 소스는 안 먹었다고 못 박으므로 제외
                dp[n][NONE][s] =
                    (dp[n - 1][NONE].sumOf { it } + dp[n - 1][ATE].sumOf { it } - (dp[n - 1][NONE][s] + dp[n - 1][ATE][s])) % 10000
                // 이전에 먹었다면 3연속 되기 때문에 전에는 s를 먹었지만 전전에는 s를 안 먹은 경우의 수 가져오기
                dp[n][ATE][s] = dp[n - 1][NONE][s]
            } else {
                for (s in 0 until 3) {
                    dp[n][NONE][s] =
                        (dp[n - 1][NONE].sumOf { it } + dp[n - 1][ATE].sumOf { it } - (dp[n - 1][NONE][s] + dp[n - 1][ATE][s])) % 10000
                    dp[n][ATE][s] = dp[n - 1][NONE][s]
                }
            }
        }
        print(dp.last().sumOf { it.sumOf { case -> case } } % 10000)
    }
}