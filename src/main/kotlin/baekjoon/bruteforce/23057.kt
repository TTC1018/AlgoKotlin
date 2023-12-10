package baekjoon.bruteforce

class `23057` {
    private val answer = mutableSetOf<Int>()
    private var N = 0
    private lateinit var nums: List<Int>

    private fun bruteforce(idx: Int, total: Int) {
        answer.add(total)
        if (idx == N)
            return

        for (i in idx until N) {
            bruteforce(i + 1, total + nums[i])
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        nums = readLine().split(" ").map(String::toInt)
        bruteforce(0, 0)
        print(nums.sumOf { it } - answer.size + 1)
    }
}