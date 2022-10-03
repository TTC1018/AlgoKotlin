package baekjoon.twopointer

import kotlin.math.abs

class `2467` {
    fun solution():String = with(System.`in`.bufferedReader()){
        val N = readLine().toInt()
        val L = readLine().split(" ").map { it.toInt() }.sorted()

        var left = 0
        var right = L.size - 1

        var answer = Pair(0, 0)
        var minVal = 2e9.toInt()
        while (left < right){
            val sumVal = L[left] + L[right]
            if (abs(sumVal) < minVal){
                minVal = abs(sumVal)
                answer = Pair(L[left], L[right])
            }

            when {
                sumVal > 0 -> right--
                sumVal < 0 -> left++
                else -> break
            }
        }

        return "${answer.first} ${answer.second}"
    }
}

fun main(){
    print(`2467`().solution())
}