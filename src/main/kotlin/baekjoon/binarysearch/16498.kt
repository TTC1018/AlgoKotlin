package baekjoon.binarysearch

import kotlin.math.absoluteValue

class `16498` {
    private fun binarySearch(t: Int, nums: List<Int>): Int {
        var (l, r) = 0 to nums.size - 1
        while (l <= r) {
            val m = (l + r).div(2)

            when {
                t == nums[m] -> return t
                t < nums[m] -> r = m - 1
                t > nums[m] -> l = m + 1
            }
        }
        return nums.getOrNull(l) ?: if (l <= 0) nums.first() else nums.last()
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val (an, bn, cn) = readLine().split(" ").map(String::toInt)
        val A = readLine().split(" ").map(String::toInt).sorted()
        val B = readLine().split(" ").map(String::toInt).sorted()
        val C = readLine().split(" ").map(String::toInt).sorted()
        var answer = Int.MAX_VALUE
        for (a in A) {
            val b = binarySearch(a, B)
            val c = binarySearch(a, C)
            answer = minOf(answer, (maxOf(a, b, c) - minOf(a, b, c)).absoluteValue)
        }
        for (b in B) {
            val a = binarySearch(b, A)
            val c = binarySearch(b, C)
            answer = minOf(answer, (maxOf(a, b, c) - minOf(a, b, c)).absoluteValue)
        }
        for (c in C) {
            val a = binarySearch(c, A)
            val b = binarySearch(c, B)
            answer = minOf(answer, (maxOf(a, b, c) - minOf(a, b, c)).absoluteValue)
        }
        print(answer)
    }
}