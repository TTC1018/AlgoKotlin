package baekjoon.bruteforce

import kotlin.math.absoluteValue

class `2548` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        val nums = mutableSetOf<Int>()
        val counter = IntArray(10000 + 1)
        readLine().split(" ").map(String::toInt).run {
            nums.addAll(this)
            for (num in this) {
                counter[num]++
            }
        }
        // N^2 불가능 -> 10000개면 가능
        var answerVal = Int.MAX_VALUE
        var answer = 0
        for (n1 in nums) {
            var temp = 0
            for (n2 in nums) {
                temp += (n1 - n2).absoluteValue * counter[n2]
            }

            if (temp <= answerVal) {
                if (temp < answerVal) {
                    answer = n1
                    answerVal = temp
                } else {
                    answer = minOf(answer, n1)
                }
            }
        }
        print(answer)
    }
}