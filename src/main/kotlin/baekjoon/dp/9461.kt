package baekjoon.dp

import java.util.Collections

class `9461` {

    fun solution()=with(System.`in`.bufferedReader()){
        val T = readLine().toInt()
        val dp = Array(100 + 1){0L}
        (1..3).forEach { i -> dp[i] = 1 }
        (4..5).forEach { i -> dp[i] = 2 }

        val ops = mutableListOf<Int>().apply {
            (1..T).forEach {
                add(readLine().toInt())
            }
        }
        val maxIdx = Collections.max(ops)

        (6..maxIdx).forEach { num ->
            dp[num] = dp[num - 1] + dp[num - 5]
        }

        ops.forEach { println(dp[it]) }
    }

}

fun main(){
    `9461`().solution()
}

