package baekjoon.greedy

import kotlin.math.log2

class `23758` {
    fun main() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        // 어차피 중앙값 위 값들은 중앙값이 되지 않음
        val a = readLine().split(" ").map(String::toInt).sorted()
            .slice(0 until kotlin.math.ceil(N.toDouble() / 2).toInt())
        // 중앙값 이하 값들이 모두 1이 될 때까지 나누다가, 하나를 0으로 만든다
        print(a.sumOf { kotlin.math.floor(log2(it.toDouble())).toLong() } + 1)
    }
}