package baekjoon.dp


// 5분 간격 -> 18번
// O / X로 계속해서 분기
// 소수 득점 = 2, 3, 5, 7, 11, 13

class `1344` {

    private var A = 0.0
    private var B = 0.0

    private val nums = setOf(2, 3, 5, 7, 11, 13, 17)

    fun solution() = with(System.`in`.bufferedReader()) {

        A = readLine().toDouble().div(100)
        B = readLine().toDouble().div(100)

        val onlyA = A * (1 - B)
        val onlyB = (1 - A) * B
        val bothAB = A * B
        val neitherAB = (1 - A) * (1 - B)

        val dp = Array(18 + 1) { Array(18 + 1) { DoubleArray(18 + 1) { 0.0 } } }
        dp[0][0][0] = 1.0

        for (total in 1..18){
            for (a in 0..total){
                for (b in 0..total){
                    if (a > 0) // a만 넣는 경우
                        dp[total][a][b] += dp[total - 1][a - 1][b] * onlyA
                    if (b > 0) // b만 넣는 경우
                        dp[total][a][b] += dp[total - 1][a][b - 1] * onlyB
                    if (a > 0 && b > 0) // 둘 다 넣는 경우
                        dp[total][a][b] += dp[total - 1][a - 1][b - 1] * bothAB
                    if (a < total && b < total) // 둘 다 못 넣는 경우
                        dp[total][a][b] += dp[total - 1][a][b] * neitherAB
                }
            }
        }

        var answer = 0.0
        for (a in 0..18){
            for (b in 0..18){
                if (a in nums || b in nums)
                    answer += dp[18][a][b]
            }
        }
        print(answer)

    }

}

fun main() {

    `1344`().solution()

}