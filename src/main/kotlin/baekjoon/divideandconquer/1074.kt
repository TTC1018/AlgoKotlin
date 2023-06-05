package baekjoon.divideandconquer

import kotlin.math.pow
import kotlin.system.exitProcess

class `1074` {

    private var N = 0
    private var r = 0
    private var c = 0
    private var order = 0

    private fun divide(x: Int, y: Int, n: Int) {
        // 내 범위 아닐 때: 개수만 세기
        if (x > r || x+n <= r || y > c || y+n <= c) {
            order += n*n
            return
        }

        if (n <= 2) {
            when {
                x == r && y+1 == c -> order++
                x+1 == r && y == c -> order+=2
                x+1 == r && y+1 == c -> order+=3
            }
            print(order)
            exitProcess(0)
        }
        else {
            val half = n/2
            divide(x, y, half)
            divide(x, y+half, half)
            divide(x+half, y, half)
            divide(x+half, y+half, half)
        }
    }

    fun solution() = with(System.`in`.bufferedReader()) {

        readLine().split(" ").map { it.toInt() }
            .also { N = it[0]; r = it[1]; c = it[2] }

        divide(0, 0, (2.0.pow(N)).toInt())

    }

}

fun main() {

    `1074`().solution()

}