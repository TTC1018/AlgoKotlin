package baekjoon.math

import java.math.BigInteger

class `15319` {

    private fun Int.toBinary(): String {
        val sb = StringBuilder()
        var n = this

        while (n > 0) {
            sb.append(n % 2)
            n /= 2
        }

        return sb.reverse().toString()
    }

    private fun String.toNumWithBase(base: Int): BigInteger {
        val numStr = this.reversed()
        var num = BigInteger.ZERO

        for (i in numStr.indices) {
            val baseNum = BigInteger.valueOf(base.toLong()).pow(i)
            val digit = BigInteger.valueOf(numStr[i].digitToInt().toLong())
            num += baseNum.multiply(digit)
        }

        return num
    }

    fun solution() = with(System.`in`.bufferedReader()) {
        val N = readLine().toInt()
        var answer = BigInteger.ZERO
        val mod = BigInteger.valueOf(1000000007)
        repeat(N) {
            val (x, K) = readLine().split(" ").map { it.toInt() }
            answer += (K.toBinary().toNumWithBase(x))
            answer %= mod
        }
        print(answer)
    }
}

fun main() {
    `15319`().solution()
}
