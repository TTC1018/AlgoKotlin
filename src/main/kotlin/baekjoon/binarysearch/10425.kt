package baekjoon.binarysearch

import java.math.BigInteger

class `10425` {
    fun solution() = with(System.`in`.bufferedReader()) {
        val F = buildList<BigInteger> {
            add(BigInteger.ZERO)
            add(BigInteger.ONE)
            repeat(99999) {
                add(this[lastIndex - 1] + last())
            }
        }
        print(
            StringBuilder().apply {
                repeat(readLine().toInt()) {
                    val n = readLine().toBigInteger()
                    var answer = 1
                    var (l, r) = 1 to 100000
                    while (l <= r) {
                        val m = (l + r) / 2
                        if (F[m] <= n) {
                            answer = m
                            l = m + 1
                        } else {
                            r = m - 1
                        }
                    }
                    appendLine(answer)
                }
            }.dropLast(1)
        )
    }
}