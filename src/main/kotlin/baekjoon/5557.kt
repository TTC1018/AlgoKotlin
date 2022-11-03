package baekjoon

class `5557` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().trim().toInt()
        val nums = readLine().trim().split(" ").map { it.toInt() }
        val dp = Array(100) { Array(20 + 1) { 0L } } // 인덱스가 곧 누적된 합
        dp[0][nums.first().toInt()] = 1

        for (i in 1 until N - 1) {
            for (sumVal in 0..20) {
                if (dp[i - 1][sumVal] > 0){
                    val plusSum = sumVal + nums[i]
                    val minusSum = sumVal - nums[i]
                    if (plusSum in 0..20)
                        dp[i][plusSum] += dp[i - 1][sumVal]
                    if (minusSum in 0..20)
                        dp[i][minusSum] += dp[i - 1][sumVal]
                }
            }
        }

        print(dp[N - 2][nums.last()])
    }

}

fun main() {

    `5557`().solution()

}