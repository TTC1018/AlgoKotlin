package baekjoon.binarysearch

class `17393` {
    private var N = 0
    private lateinit var A: List<Long>
    private lateinit var B: List<Long>
    private lateinit var answer: IntArray

    private fun binarySearch(s: Int, lower: Boolean = true): Int {
        val target = A[s]
        var (l, r) = s to N - 1
        var result = l
        while (l <= r) {
            val m = (l + r).div(2)

            if (lower) {
                if (B[m] <= target) {
                    r = m - 1
                    result = m
                } else {
                    l = m + 1
                }
            } else {
                if (B[m] <= target) {
                    l = m + 1
                    result = m
                } else {
                    r = m - 1
                }
            }
        }
        return result
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        A = readLine().split(" ").map(String::toLong)
        B = readLine().split(" ").map(String::toLong)
        answer = IntArray(N)
        for (i in 0 until A.lastIndex) {
            val left = binarySearch(i)
            val right = binarySearch(i, false)
            answer[i] = (right - left)
        }
        print(answer.joinToString(" "))
    }
}