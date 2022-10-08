package baekjoon.dp

import java.util.Collections

class `15988` {

    fun solution()=with(System.`in`.bufferedReader()){
        val T = readLine().toInt()
        val ops = mutableListOf<Int>().apply {
            (1..T).forEach { add(readLine().toInt()) }
        }
        val maxInx = Collections.max(ops)

        val mod = 1000000009
        val dp = Array(1000001) {0L}
        dp[1] = 1 // 1
        dp[2] = 2 // 1 + 1, 2
        dp[3] = 4 // 1 + 1 + 1, 1 + 2, 2 + 1, 3

        (4..maxInx).forEach { num ->
            dp[num] = (dp[num - 1] + dp[num - 2] + dp[num - 3]).rem(mod)
        }

        ops.forEach { num -> println(dp[num]) }
    }

}

fun main(){
    `15988`().solution()
}