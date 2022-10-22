package baekjoon.greedy

import kotlin.math.min

class `1783` {

    fun solution() = with(System.`in`.bufferedReader()){

        val (N, M) = readLine().split(" ").map { it.toInt() }

        when (N) {
            1 -> println(1)
            2 -> println(min(1 + (M - 1) / 2, 4))
            else -> {
                when {
                    M < 7 -> println(min(M, 4))
                    else -> println(5 + M - 7)
                }
            }
        }

    }

}

fun main(){

    `1783`().solution()

}