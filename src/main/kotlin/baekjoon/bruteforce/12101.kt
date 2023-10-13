package baekjoon.bruteforce

import kotlin.system.exitProcess

class `12101` {
    private var n = 0
    private var k = 0
    private var answer = 0
    private val nums = mutableListOf<Int>()

    private fun bruteforce(total: Int) {
        if (total > n)
            return
        if (total == n) {
            answer++
            if (answer == k) {
                print(nums.joinToString("+"))
                exitProcess(0)
            }
            return
        }

        for (num in 1..3) {
            nums.add(num)
            bruteforce(total + num)
            nums.removeLast()
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        readLine().split(" ").map(String::toInt).run {
            n = first(); k = last()
        }

        bruteforce(0)
        print(-1)
    }
}

fun main() {
    `12101`().solution()
}