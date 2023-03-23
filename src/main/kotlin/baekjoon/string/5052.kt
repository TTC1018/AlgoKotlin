package baekjoon.string

import kotlin.math.min


class `5052` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val T = readLine().trim().toInt()
        val answer = mutableListOf<String>()
        testcase@ for (t in 0 until T) {

            val N = readLine().trim().toInt()
            val nums = Array(N) { readLine().trim() }.sorted()
            if (N == 1) {
                answer.add("YES")
                continue@testcase
            }

            for (i in 0 until N - 1) {
                if (nums[i] == nums[i + 1].slice(0 until min(nums[i].length, nums[i + 1].length))) {
                    answer.add("NO")
                    continue@testcase
                }
            }
            answer.add("YES")

        }

        print(answer.joinToString("\n"))
    }

}

fun main() {

    `5052`().solution()

}