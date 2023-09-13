package baekjoon.bruteforce

import kotlin.system.exitProcess

class `16936` {
    private var N = 0
    private lateinit var nums: LongArray
    private lateinit var visited: BooleanArray
    private val answer = mutableListOf<Long>()

    private fun bruteforce(cnt: Int) {
        if (cnt == N) {
            print(answer.joinToString(" "))
            exitProcess(0)
        }

        for (i in nums.indices) {
            if (visited[i].not()) {
                answer.lastOrNull()?.let { prev ->
                    if (prev % 3 == 0L && prev / 3 == nums[i]) {
                        visited[i] = true
                        answer.add(nums[i])
                        bruteforce(cnt + 1)
                        visited[i] = false
                        answer.removeLast()
                    } else if (prev * 2 == nums[i]) {
                        visited[i] = true
                        answer.add(nums[i])
                        bruteforce(cnt + 1)
                        visited[i] = false
                        answer.removeLast()
                    }

                    prev
                } ?: run {
                    visited[i] = true
                    answer.add(nums[i])
                    bruteforce(cnt + 1)
                    visited[i] = false
                    answer.removeLast()
                }
            }
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        N = readLine().toInt()
        nums = readLine().split(" ").map(String::toLong).toLongArray()
        visited = BooleanArray(N) { false }

        bruteforce(0)
    }
}

fun main() {
    `16936`().solution()
}