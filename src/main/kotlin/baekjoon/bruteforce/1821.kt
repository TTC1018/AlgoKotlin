package baekjoon.bruteforce

import kotlin.system.exitProcess

class `1821` {

    private var N = 0
    private var F = 0
    private var visited = 0
    private lateinit var nums: IntArray

    private fun Int.toBit() = (1 shl this)

    private fun bruteforce(cnt: Int) {
        if (cnt == N) {
            var left = N
            val temp = nums.copyOf()
            while (left > 1) {
                for (i in 0 until left - 1) {
                    temp[i] = temp[i] + temp[i+1]
                }
                left--
            }

            if (temp[0] == F) {
                print(nums.joinToString(" "))
                exitProcess(0)
            }
            return
        }

        for (num in 1..N) {
            val bit = num.toBit()
            if (visited and bit != bit) {
                visited = visited xor bit
                nums[cnt] = num
                bruteforce(cnt + 1)
                nums[cnt] = 0
                visited = visited xor bit
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map(String::toInt).also { N = it[0]; F = it[1] }
        nums = IntArray(N)
        bruteforce(0)

    }

}

fun main() {

    `1821`().solution()

}