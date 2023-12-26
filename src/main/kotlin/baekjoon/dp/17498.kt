package baekjoon.dp

class `17498` {
    fun main() = with(System.`in`.bufferedReader()) {
        val (N, M, D) = readLine().split(" ").map(String::toInt)
        val B = List(N) { readLine().split(" ").map(String::toInt) }
        // 1번 행에서 아래로 이동
        // D이하로 이동 가능 -> 다른 열에서도 올 수 있음
        // 이전 칸과 현재 칸의 수를 곱해서 점수에 더함
        // 낼 수 있는 최대 점수는?
        val dp = List(N) { IntArray(M) { Int.MIN_VALUE } }.apply {
            for (j in 0 until M)
                this[0][j] = 0
        }
        for (i in 1 until N) {
            for (j in 0 until M) {
                // 거리 D 이내의 영역 탐색 = 트리 모양
                for (d in 1..D) {
                    val pi = (i-d)
                    val pjRange = j-(D-d)..j+(D-d)
                    for (pj in pjRange) {
                        if (pi in 0 until N && pj in 0 until M) {
                            dp[i][j] = maxOf(dp[i][j], dp[pi][pj] + B[pi][pj]*B[i][j])
                        }
                    }
                }
            }
        }
        print(dp.last().maxOf { it })
    }
}