package baekjoon.greedy

import kotlin.math.absoluteValue

class `2405` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val n = readLine().toInt()
        val nums = IntArray(n) { readLine().toInt() }.sortedArray()

        // |3b - (a+b+c) -> 2b-a-c|
        val big = nums.last()
        val small = nums.first()
        var answer = 0
        nums.dropLast(1).zipWithNext { a, b ->
            answer = maxOf(answer, (big+a-2*b).absoluteValue)
        }
        nums.drop(1).zipWithNext { b, c ->
            answer = maxOf(answer, (2*b-small-c).absoluteValue)
        }
        print(answer)
    }
}