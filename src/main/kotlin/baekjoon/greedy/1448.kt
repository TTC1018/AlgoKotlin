package baekjoon.greedy

class `1448` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = List(N) { readLine().toInt() }.sortedDescending()
        for (i in 0 until N - 2) {
            if (nums[i] < nums[i + 1] + nums[i + 2]) {
                print(nums[i] + nums[i + 1] + nums[i + 2])
                return
            }
        }
        print(-1)
    }
}