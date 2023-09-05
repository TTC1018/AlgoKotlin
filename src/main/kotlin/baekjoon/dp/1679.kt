package baekjoon.dp

class `1679` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = readLine().split(" ").map(String::toInt).toIntArray()
        val K = readLine().toInt()

        val dp = Array(K*nums.last() + 1) { BooleanArray(K + 1) { false } }
        dp[0][0] = true
        dp[1][1] = true

        var now = 2
        while (true) {
            var flag = false
            for (num in nums) {
                val prev = now - num
                if (prev < 0)
                    break

                for (cnt in 0 until K) {
                    if (dp[prev][cnt]) {
                        dp[now][cnt + 1] = true
                        flag = true
                    }
                }
            }

            if (flag)
                now++
            else {
                if (now % 2 == 0) {
                    print("holsoon win at $now")
                } else {
                    print("jjaksoon win at $now")
                }
                break
            }
        }
    }
}

fun main() {
    `1679`().solution()
}