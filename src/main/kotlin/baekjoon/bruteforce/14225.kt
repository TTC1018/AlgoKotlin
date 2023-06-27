package baekjoon.bruteforce

class `14225` {
    private var N = 0
    private lateinit var S: IntArray
    private lateinit var visited: BooleanArray
    private var sumVal = 0
    private val answer = mutableSetOf<Int>()
    private fun bruteforce(idx: Int) {
        if (sumVal > 0)
            answer.add(sumVal)

        for (i in idx until N) {
            if (visited[i].not()) {
                visited[i] = true
                sumVal += S[i]
                bruteforce(i + 1)
                sumVal -= S[i]
                visited[i] = false
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        S = readLine().split(" ").map(String::toInt).toIntArray()
        visited = BooleanArray(N)
        bruteforce(0)

        val nums = answer.sorted()
        var prev = 0
        for (i in nums.indices) {
            if (nums[i] - prev != 1) {
                print(prev + 1)
                return
            }
            prev = nums[i]
        }
        print(nums.last() + 1)
    }
}

fun main() { `14225`().solution() }