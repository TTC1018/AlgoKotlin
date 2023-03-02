package baekjoon.dp

private const val MOD = 9901

class `1309` {

    enum class Case {
        OX, XO, XX
    }

    fun solution() = with(System.`in`.bufferedReader()){

        val N = readLine().toInt()
        val dp = Array(N + 1) { IntArray(3) }
        dp[1][Case.OX.ordinal] = 1
        dp[1][Case.XO.ordinal] = 1
        dp[1][Case.XX.ordinal] = 1

        for (j in 2.. N){
            dp[j][Case.OX.ordinal] = (dp[j - 1][Case.XO.ordinal] + dp[j - 1][Case.XX.ordinal]) % MOD
            dp[j][Case.XO.ordinal] = (dp[j - 1][Case.OX.ordinal] + dp[j - 1][Case.XX.ordinal]) % MOD
            dp[j][Case.XX.ordinal] = (dp[j - 1][Case.OX.ordinal] + dp[j - 1][Case.XO.ordinal] + dp[j - 1][Case.XX.ordinal]) % MOD
        }

        print(dp[N].sumOf { it } % MOD)
    }

}

fun main() {

    `1309`().solution()

}