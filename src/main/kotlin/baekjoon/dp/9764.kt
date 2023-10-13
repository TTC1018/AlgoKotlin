package baekjoon.dp

private const val MOD = 100999

class `9764` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val dp = List(2000 + 1) { IntArray(2000 + 1) }.apply {
            for (n in 0..2000) {
                this[0][n] = 1 // 1 -> 1, 2 -> 2 등 단일 숫자 개수 세팅
            }

            for (n in 1..2000) {
                // p 미만의 수로 만든 조합에 p를 더해 n 만들기
                for (p in 1..n) {
                    this[n][p] += this[n-p][p-1]
                    this[n][p] %= MOD
                }
                // p 빼고 n 만든 조합
                for (p in 1..2000) {
                    this[n][p] += this[n][p-1]
                    this[n][p] %= MOD
                }
            }
        }

        repeat(readLine().toInt()) {
            readLine().toInt().run {
                println(dp[this][this])
            }
        }
    }
}