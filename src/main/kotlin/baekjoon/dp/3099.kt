package baekjoon.dp

class `3099` {
    private fun Char.toIdx() = this - 'A'

    fun solution() = with(System.`in`.bufferedReader()) {
        val S = readLine()
        // 경우의 수 -> SET이냐 NEXT냐 WRITE냐
        // S[i]까지 왔는데 현재 메모리에 alpha가 저장돼있는 경우의 횟수
        val dp = List(S.length) { IntArray('Z' - 'A' + 1) { S.length * 2 } }.apply {
            this[0][S.first().toIdx()] = 2 // SET - WRITE
        }
        for (i in 1 until S.length) {
            for (alpha in 'A'..'Z') {
                if (dp[i - 1][alpha.toIdx()] != S.length * 2) {
                    if (S[i] == alpha) { // WRITE만 하면 됨
                        dp[i][alpha.toIdx()] = minOf(dp[i][alpha.toIdx()], dp[i - 1][alpha.toIdx()] + 1)
                    } else { // NEXT-WRITE OR SET-WRITE
                        dp[i][S[i].toIdx()] = minOf(dp[i][S[i].toIdx()], dp[i - 1][alpha.toIdx()] + 2)
                        dp[i][alpha.toIdx()] = minOf(dp[i][alpha.toIdx()], dp[i - 1][alpha.toIdx()] + 2)
                    }
                }
            }
        }
        print(dp.last().minOf { it })
    }
}