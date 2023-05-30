package baekjoon.dp

class `1720` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val dp = IntArray(N + 1)
        when {
            N in 1..4 -> {
                when (N) {
                    1 -> print(1)
                    2 -> print(3)
                    3 -> print(3)
                    4 -> print(8)
                }
                return
            }
        }

        dp[1] = 1; dp[2] = 3;
        for (n in 3..N) {
            dp[n] = dp[n - 1] + dp[n - 2] * 2
        }

        val dpSym = IntArray(N + 1)
        dpSym[1] = 1; dpSym[2] = 3;
        dpSym[3] = 1; dpSym[4] = 5;
        for (n in 5..N) {
            // 길이 2 짧은 곳 양쪽에 2*1 블럭 붙이기 or 길이 4 짧은 곳 양쪽에 2*2 or 1*2 블록 붙이기
            dpSym[n] = dpSym[n - 2] + dpSym[n - 4] * 2
        }

        // 전체 - 대칭으로 하나만 존재하는 경우의 수 제외하고 나머지는 반으로 나누기 (2개씩 존재하는 대칭의 개수)
        print(dp[N] - (dp[N] - dpSym[N]) / 2)
    }

}

fun main() {

    `1720`().solution()

}