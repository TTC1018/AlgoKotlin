package baekjoon.bruteforce

class `25401` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = readLine().split(" ").map(String::toInt)
        var answer = Int.MAX_VALUE
        for (i in nums.indices) {
            for (j in i+1 until N) {
                val dist = j - i
                val diff = nums[j] - nums[i]
                var tempCnt = 0
                if (diff % dist == 0) {
                    val cand = diff / dist
                    val start = nums[i] - i * cand
                    for (k in nums.indices) {
                        if (nums[k] != start + cand * k) {
                            tempCnt++
                        }
                    }
                    answer = minOf(answer, tempCnt)
                }
            }
        }
        print(answer)
    }
}