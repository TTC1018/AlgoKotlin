package baekjoon.dp

import java.math.BigInteger

class `1793` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val dp = buildList<BigInteger> {
            add(BigInteger.ONE)
            add(BigInteger.ONE)
            add(BigInteger.valueOf(3))
            repeat(250 - 3 + 1) {
                add(last() + this[size - 2].multiply(BigInteger.valueOf(2)))
            }
        }
        while (true) {
            try {
                val n = readLine()
                if (n.isNullOrEmpty())
                    break
                println(dp[n.toInt()])
            } catch (e: Exception) {
                break
            }
        }
    }
}