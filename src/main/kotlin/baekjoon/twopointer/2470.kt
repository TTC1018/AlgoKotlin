package baekjoon.twopointer

import kotlin.math.abs

class `2470` {

    fun solution() = with(System.`in`.bufferedReader()) {

        val N = readLine().toInt()
        val liquids = readLine().split(" ").map { it.toInt() }.toTypedArray()
        liquids.sort()

        var left = 0
        var right = N - 1

        var answerVal = Int.MAX_VALUE
        var answerLeft = liquids.first()
        var answerRight = liquids.last()
        while (left < right){
            val sumVal = liquids[left] + liquids[right]

            if (abs(sumVal) < answerVal){
                answerLeft = liquids[left]
                answerRight = liquids[right]
                answerVal = abs(sumVal)

            }

            when {
                sumVal == 0 -> break
                sumVal > 0 -> right--
                else -> left++
            }
        }

        print("$answerLeft $answerRight")
    }

}

fun main() {

    `2470`().solution()

}