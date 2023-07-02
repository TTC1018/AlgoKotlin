package baekjoon.dp

class `20162` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val S = Array(N) { readLine().toInt() }
        val dp = IntArray(N).also { it[0] = S[0] }

        for (i in 1 until N) {
            dp[i] = S[i]
            for (j in 0 until i) {
                if (S[i] > S[j])
                    dp[i] = maxOf(dp[i], dp[j] + S[i])
            }
        }

        print(dp.maxOf { it })
    }
}

fun main() { `20162`().solution() }