package baekjoon.bruteforce

class `15658` {
    private var N = 0
    private lateinit var A: List<Int>
    private lateinit var cnt: IntArray
    private var maxVal = Int.MIN_VALUE
    private var minVal = Int.MAX_VALUE

    private val formula: List<(Int, Int) -> Int> = listOf(
        { a, b -> a + b },
        { a, b -> a - b },
        { a, b -> a * b },
        { a, b -> if (a < 0) -(-a / b) else a / b }
    )

    private fun bruteforce(idx: Int, num: Int) {
        if (idx == N) {
            maxVal = maxOf(maxVal, num)
            minVal = minOf(minVal, num)
            return
        }

        for (i in cnt.indices) {
            if (cnt[i] > 0) {
                cnt[i]--
                bruteforce(idx + 1, formula[i](num, A[idx]))
                cnt[i]++
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        A = readLine().split(" ").map(String::toInt)
        cnt = readLine().split(" ").map(String::toInt).toIntArray()

        bruteforce(1, A.first())

        print("$maxVal\n$minVal")
    }
}

fun main() {
    `15658`().solution()
}