package baekjoon.dp

class `17070` {

    fun solution() = with(System.`in`.bufferedReader()){

        val N = readLine().toInt()
        val graph = List(N) { readLine().split(" ").map { it.toInt() }.toMutableList() }
        val dp = List(N) { List(N) { MutableList(3) { 0 } } } // 0 행 1 대각 2 열
        dp[0][1][0] = 1
        for (col in 2 until N){
            if (graph[0][col] == 0)
                dp[0][col][0] = dp[0][col - 1][0]
        }

        for (row in 1 until N){
            for (col in 2 until N){
                if (graph[row][col] == 0){
                    dp[row][col][0] = dp[row][col - 1][0] + dp[row][col - 1][1] // 가로로 이어질 경우의 수 (가로, 대각)
                    dp[row][col][2] = dp[row - 1][col][2] + dp[row - 1][col][1] // 세로로 이어질 경우의 수 (세로, 대각)
                    if (graph[row - 1][col] == 0 && graph[row][col - 1] == 0)
                        dp[row][col][1] = dp[row - 1][col - 1].sumOf { it }
                }
            }
        }

        println(dp[N - 1][N - 1].sumOf { it })
    }

}

fun main() {

    `17070`().solution()

}