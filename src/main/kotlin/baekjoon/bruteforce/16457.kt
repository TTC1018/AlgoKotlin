package baekjoon.bruteforce

class `16457` {
    private var n = 0
    private var m = 0
    private var k = 0
    private lateinit var Q: List<List<Int>>
    private lateinit var nums: BooleanArray
    private var answer = 0

    private fun bruteforce(now: Int, cnt: Int) {
        if (cnt == n) {
            answer = maxOf(answer, Q.count { q -> q.all { nums[it] } })
            return
        }

        for (i in now..n*2) {
            nums[i] = true
            bruteforce(i + 1, cnt + 1)
            nums[i] = false
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            n = first(); m = this[1]; k = last()
        }
        Q = List(m) { readLine().split(" ").map(String::toInt) }
        nums = BooleanArray(n*2 + 1) { false }
        bruteforce(1, 0)
        print(answer)
    }
}