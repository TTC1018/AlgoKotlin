package baekjoon.dp

class `1495` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val (N, S, M) = readLine().split(" ").map { it.toInt() }
        val V = readLine().split(" ").map { it.toInt() }.toIntArray()
        val dp = Array(N + 1) { BooleanArray(M + 1) { false } }
        dp[0][S] = true

        for (i in 1 .. N){
            for (j in 0..M){
                val minus = j - V[i - 1]
                val plus = j + V[i - 1]
                if (minus >= 0 && dp[i - 1][j])
                    dp[i][minus] = true
                if (plus <= M && dp[i - 1][j])
                    dp[i][plus] = true
            }
        }

        for (i in M downTo 0){
            if (dp[N][i]){
                print(i)
                return
            }
        }
        print(-1)
    }

}

fun main() {

    `1495`().solution()

}